package com.example.knowtogrow;

import com.example.knowtogrow.pojoclass.NewsData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("top-headlines")
    Call<NewsData> getNewsDataByCountry(@Query("country") String country, @Query("apiKey") String apiKey);

    @GET("top-headlines")
    Call<NewsData> getNewsDataByCategory(@Query("category") String category, @Query("apiKey") String apiKey);

    @GET("everything")
    Call<NewsData> getNewsDataByCategoryFromEverything(@Query("q") String category, @Query("apiKey") String apiKey);





}
