package com.example.projectdraft1;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static final String BASE_URL="https://newsapi.org/v2/";//top-headlines?country=us&apiKey=caa499b2e6c24924b338c495a2a7a497
    private static Retrofit retrofit;

    public static String getBaseUrl(){
        return BASE_URL;
    }

    public static Retrofit getApiClient(){
        if(retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return retrofit;

    }
}
