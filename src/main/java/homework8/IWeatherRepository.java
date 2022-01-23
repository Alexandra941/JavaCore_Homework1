package homework8;

import homework7.entity.Weather;

import java.sql.SQLException;
import java.util.List;

public interface IWeatherRepository {
    void saveWeather(Weather weather) throws SQLException;

    void saveWeathers(List<Weather> weatherList) throws SQLException;

    List<Weather> getAll() throws SQLException;

    List<Weather> getAllByCity(String citye) throws SQLException;

}
