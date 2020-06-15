package com.shridhar.androidassignmentsecond.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BgGradient {

    @SerializedName("angle")
    @Expose
    private Integer angle;
    @SerializedName("colors")
    @Expose
    private List<String> colors = null;

    public Integer getAngle() {
        return angle;
    }

    public void setAngle(Integer angle) {
        this.angle = angle;
    }

    public List<String> getColors() {
        return colors;
    }

    public void setColors(List<String> colors) {
        this.colors = colors;
    }

}