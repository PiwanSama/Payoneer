package com.sample.payoneer.api;

import com.sample.payoneer.model.ListResult;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NetworkService {
    @GET("/listresult.json")
    Call<ListResult> getData();
}
