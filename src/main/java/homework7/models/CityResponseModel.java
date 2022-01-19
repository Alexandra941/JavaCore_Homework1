package homework7.models;

import com.google.gson.annotations.SerializedName;

public class CityResponseModel {

    @SerializedName("Version")
    private int version;

    @SerializedName("Key")
    private String key;

    @SerializedName("Type")
    private String type;

    @SerializedName("Rank")
    private int rank;

    @SerializedName("LocalizedName")
    private String localizedName;

    public CityResponseModel(int version, String key, String type, int rank, String localizedName) {
        this.version = version;
        this.key = key;
        this.type = type;
        this.rank = rank;
        this.localizedName = localizedName;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getLocalizedName() {
        return localizedName;
    }

    public void setLocalizedName(String localizedName) {
        this.localizedName = localizedName;
    }
}
