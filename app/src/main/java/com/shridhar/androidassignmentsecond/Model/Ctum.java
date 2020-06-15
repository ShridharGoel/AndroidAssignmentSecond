package com.shridhar.androidassignmentsecond.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Ctum {

    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("bg_color")
    @Expose
    private String bgColor;
    @SerializedName("other_url")
    @Expose
    private String otherUrl;
    @SerializedName("text_color")
    @Expose
    private String textColor;
    @SerializedName("url_choice")
    @Expose
    private String urlChoice;
    @SerializedName("url")
    @Expose
    private String url;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getBgColor() {
        return bgColor;
    }

    public void setBgColor(String bgColor) {
        this.bgColor = bgColor;
    }

    public String getOtherUrl() {
        return otherUrl;
    }

    public void setOtherUrl(String otherUrl) {
        this.otherUrl = otherUrl;
    }

    public String getTextColor() {
        return textColor;
    }

    public void setTextColor(String textColor) {
        this.textColor = textColor;
    }

    public String getUrlChoice() {
        return urlChoice;
    }

    public void setUrlChoice(String urlChoice) {
        this.urlChoice = urlChoice;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}