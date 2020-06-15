package com.shridhar.androidassignmentsecond.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Entity_ {

    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("color")
    @Expose
    private String color;
    @SerializedName("font_style")
    @Expose
    private String fontStyle;
    @SerializedName("url_choice")
    @Expose
    private String urlChoice;
    @SerializedName("font_family")
    @Expose
    private String fontFamily;
    @SerializedName("url")
    @Expose
    private String url;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFontStyle() {
        return fontStyle;
    }

    public void setFontStyle(String fontStyle) {
        this.fontStyle = fontStyle;
    }

    public String getUrlChoice() {
        return urlChoice;
    }

    public void setUrlChoice(String urlChoice) {
        this.urlChoice = urlChoice;
    }

    public String getFontFamily() {
        return fontFamily;
    }

    public void setFontFamily(String fontFamily) {
        this.fontFamily = fontFamily;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}