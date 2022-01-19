package homework7.models;

import com.google.gson.annotations.SerializedName;

public class Temperature {
    @SerializedName("Minimum")
    private TemperatureInfo minimum;

    @SerializedName("Maximum")
    private TemperatureInfo maximum;

    public Temperature(TemperatureInfo minimum, TemperatureInfo maximum) {
        this.minimum = minimum;
        this.maximum = maximum;
    }

    public TemperatureInfo getMinimum() {
        return minimum;
    }

    public void setMinimum(TemperatureInfo minimum) {
        this.minimum = minimum;
    }

    public TemperatureInfo getMaximum() {
        return maximum;
    }

    public void setMaximum(TemperatureInfo maximum) {
        this.maximum = maximum;
    }
}
