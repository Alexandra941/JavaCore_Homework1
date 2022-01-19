package homework7.models;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class DailyForecasts {

    @SerializedName("Date")
    private Date date;

    @SerializedName("EpochDate")
    private long epochDate;

    @SerializedName("Day")
    private TimeOfDay day;

    @SerializedName("Night")
    private TimeOfDay night;

    @SerializedName("Temperature")
    private Temperature temperature;

    public DailyForecasts(Date date, long epochDate, TimeOfDay day, TimeOfDay night, Temperature temperature) {
        this.date = date;
        this.epochDate = epochDate;
        this.day = day;
        this.night = night;
        this.temperature = temperature;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public long getEpochDate() {
        return epochDate;
    }

    public void setEpochDate(long epochDate) {
        this.epochDate = epochDate;
    }

    public TimeOfDay getDay() {
        return day;
    }

    public void setDay(TimeOfDay day) {
        this.day = day;
    }

    public TimeOfDay getNight() {
        return night;
    }

    public void setNight(TimeOfDay night) {
        this.night = night;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }
}
