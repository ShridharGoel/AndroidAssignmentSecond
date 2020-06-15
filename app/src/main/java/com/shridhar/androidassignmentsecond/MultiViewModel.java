package com.shridhar.androidassignmentsecond;

public class MultiViewModel {
    public static final int TYPE_HC1 = 0;
    public static final int TYPE_HC3 = 1;
    public static final int TYPE_HC4 = 2;
    public static final int TYPE_HC5 = 3;
    public static final int TYPE_HC6 = 4;

    public int type;
    public int data;
    public String text;

    public MultiViewModel(int type, String text, int data) {
        this.type = type;
        this.data = data;
        this.text = text;
    }
}