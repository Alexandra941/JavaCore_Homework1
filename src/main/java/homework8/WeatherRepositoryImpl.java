package homework8;

import homework7.entity.Weather;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WeatherRepositoryImpl implements IWeatherRepository {

    private Connection connection;

    @Override
    public void saveWeather(Weather weather) throws SQLException {
        try {
            PreparedStatement preparedStatement;

            if (connection == null || connection.isClosed())
                openConnection();

            preparedStatement = connection.prepareStatement(
                    "insert into weather (city, localDate, weatherText, temperature) values (?, ?, ?, ?)");

            preparedStatement.setString(1, weather.getCity());
            preparedStatement.setString(2, weather.getLocalDate());
            preparedStatement.setString(3, weather.getWeatherText());
            preparedStatement.setDouble(4, weather.getTemperature());

            preparedStatement.execute();

            connection.commit();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        finally {
            if (connection != null && !connection.isClosed())
                closeConnection();
        }
    }

    @Override
    public void saveWeathers(List<Weather> weatherList) throws SQLException {
        try {
            PreparedStatement preparedStatement;

            if (connection == null || connection.isClosed())
                openConnection();

            preparedStatement = connection.prepareStatement(
                    "insert into weather (city, localDate, weatherText, temperature) values (?, ?, ?, ?)");
            for (Weather weather : weatherList) {
                preparedStatement.setString(1, weather.getCity());
                preparedStatement.setString(2, weather.getLocalDate());
                preparedStatement.setString(3, weather.getWeatherText());
                preparedStatement.setDouble(4, weather.getTemperature());
                preparedStatement.addBatch();
            }

            preparedStatement.executeBatch();

            connection.commit();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        finally {
            if (connection != null && !connection.isClosed())
                closeConnection();
        }
    }

    @Override
    public List<Weather> getAll() throws SQLException {
        List<Weather> weatherList = new ArrayList<Weather>();
        try {
            if (connection == null || connection.isClosed())
                openConnection();

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT id, city, localDate, weatherText, temperature FROM weather");
            while (resultSet.next()) {
                weatherList.add(new Weather(resultSet.getInt("id"),
                        resultSet.getString("city"),
                        resultSet.getString("localDate"),
                        resultSet.getString("weatherText"),
                        resultSet.getDouble("temperature")));
            }
        }
        catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        finally {
            if (connection != null && !connection.isClosed())
                closeConnection();
        }
        return weatherList;
    }

    @Override
    public List<Weather> getAllByCity(String city) throws SQLException {
        List<Weather> weatherList = new ArrayList<Weather>();
        try {
            if (connection == null || connection.isClosed())
                openConnection();

            PreparedStatement statement = connection.prepareStatement("SELECT id, city, localDate, weatherText, temperature FROM weather where city = ?");
            statement.setString(1, city);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                weatherList.add(new Weather(resultSet.getInt("id"),
                        resultSet.getString("city"),
                        resultSet.getString("localDate"),
                        resultSet.getString("weatherText"),
                        resultSet.getDouble("temperature")));
            }
        }
        catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        finally {
            if (connection != null && !connection.isClosed())
                closeConnection();
        }
        return weatherList;
    }

    private void openConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:geekbrains.db");
        connection.setAutoCommit(false);
    }

    private void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
