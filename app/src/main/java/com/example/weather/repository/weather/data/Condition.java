package com.example.weather.repository.weather.data;

import com.google.gson.annotations.SerializedName;

public class Condition {
    private String text;
    @SerializedName("icon")
    private String iconURL;
    private int code;

    // GETTERS
    public String getText() {
        return text;
    }

    public String getIconURL() {
        return iconURL;
    }

    public int getCode() {
        return code;
    }

    // SETTERS
    public void setText(String text) {
        this.text = text;
    }

    public void setIconURL(String iconURL) {
        this.iconURL = iconURL;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
