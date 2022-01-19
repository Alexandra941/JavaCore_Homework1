package homework7.models;

import com.google.gson.annotations.SerializedName;

public class Headline {
    @SerializedName("Text")
    private String text;

    public Headline(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
