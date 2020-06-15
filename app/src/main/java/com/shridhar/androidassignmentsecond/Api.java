package com.shridhar.androidassignmentsecond;

import com.shridhar.androidassignmentsecond.Model.CardDetails;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    String BASE_URL = "http://www.mocky.io/v2/";

    @GET("5ed79368320000a0cc27498b")
    Call<List<CardDetails>> getCardDetails();
}
