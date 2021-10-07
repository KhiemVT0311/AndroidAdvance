package com.eup.androidadvancedemo.api;

import com.eup.androidadvancedemo.model.NewsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {
    @GET("everything")
    Call<NewsResponse> getNews(
            @Query("q") String q,
            @Query("apiKey") String apiKey
    );
}
