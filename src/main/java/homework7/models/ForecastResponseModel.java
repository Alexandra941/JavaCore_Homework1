package homework7.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ForecastResponseModel {
    @SerializedName("Headline")
    private Headline headline;

    @SerializedName("DailyForecasts")
    private List<DailyForecasts> dailyForecasts;

    public ForecastResponseModel(Headline headline, List<DailyForecasts> dailyForecasts) {
        this.headline = headline;
        this.dailyForecasts = dailyForecasts;
    }

    public Headline getHeadline() {
        return headline;
    }

    public void setHeadline(Headline headline) {
        this.headline = headline;
    }

    public List<DailyForecasts> getDailyForecasts() {
        return dailyForecasts;
    }

    public void setDailyForecasts(List<DailyForecasts> dailyForecasts) {
        this.dailyForecasts = dailyForecasts;
    }
}
