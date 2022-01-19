package homework7.models;

import com.google.gson.annotations.SerializedName;

public class TemperatureInfo {
    @SerializedName("Value")
    private double value;

    @SerializedName("Unit")
    private String unit;

    @SerializedName("UnitType")
    private int unitType;

    public TemperatureInfo(double value, String unit, int unitType) {
        this.value = value;
        this.unit = unit;
        this.unitType = unitType;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getUnitType() {
        return unitType;
    }

    public void setUnitType(int unitType) {
        this.unitType = unitType;
    }
}
