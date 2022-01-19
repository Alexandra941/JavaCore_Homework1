package homework7.models;

import com.google.gson.annotations.SerializedName;

public class TimeOfDay {
    @SerializedName("Icon")
    private int icon;

    @SerializedName("IconPhrase")
    private String iconPhrase;

    @SerializedName("HasPrecipitation")
    private boolean hasPrecipitation;

    @SerializedName("PrecipitationType")
    private String precipitationType;

    @SerializedName("PrecipitationIntensity")
    private String precipitationIntensity;

    public TimeOfDay(int icon, String iconPhrase, boolean hasPrecipitation, String precipitationType, String precipitationIntensity) {
        this.icon = icon;
        this.iconPhrase = iconPhrase;
        this.hasPrecipitation = hasPrecipitation;
        this.precipitationType = precipitationType;
        this.precipitationIntensity = precipitationIntensity;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getIconPhrase() {
        return iconPhrase;
    }

    public void setIconPhrase(String iconPhrase) {
        this.iconPhrase = iconPhrase;
    }

    public boolean isHasPrecipitation() {
        return hasPrecipitation;
    }

    public void setHasPrecipitation(boolean hasPrecipitation) {
        this.hasPrecipitation = hasPrecipitation;
    }

    public String getPrecipitationType() {
        return precipitationType;
    }

    public void setPrecipitationType(String precipitationType) {
        this.precipitationType = precipitationType;
    }

    public String getPrecipitationIntensity() {
        return precipitationIntensity;
    }

    public void setPrecipitationIntensity(String precipitationIntensity) {
        this.precipitationIntensity = precipitationIntensity;
    }
}
