package homework7.entity;

public class Weather {
    private int id;
    private String city;
    private String localDate;
    private String weatherText;
    private double temperature;

    public Weather(String city, String localDate, String weatherText, double temperature) {
        this.id = id;
        this.city = city;
        this.localDate = localDate;
        this.weatherText = weatherText;
        this.temperature = temperature;
    }

    public Weather(int id, String city, String localDate, String weatherText, double temperature) {
        this.id = id;
        this.city = city;
        this.localDate = localDate;
        this.weatherText = weatherText;
        this.temperature = temperature;
    }

    public int getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLocalDate() {
        return localDate;
    }

    public void setLocalDate(String localDate) {
        this.localDate = localDate;
    }

    public String getWeatherText() {
        return weatherText;
    }

    public void setWeatherText(String weatherText) {
        this.weatherText = weatherText;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public String info() {
        return "В городе " + this.city +
                " на дату " + this.localDate +
                " ожидается " + this.weatherText +
                " температура " + this.temperature + " C";
    }

    @Override
    public String toString() {
        return "Weather{" +
                "city='" + city + '\'' +
                ", localDate='" + localDate + '\'' +
                ", weatherText='" + weatherText + '\'' +
                ", temperature=" + String.format("%.2f", temperature) +
                '}';
    }
}
