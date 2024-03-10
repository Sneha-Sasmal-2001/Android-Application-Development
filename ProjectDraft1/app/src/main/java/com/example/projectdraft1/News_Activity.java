package com.example.projectdraft1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.projectdraft1.pojoclass.News;
import com.example.projectdraft1.pojoclass.NewsData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class News_Activity extends AppCompatActivity {
   int count=0;
    AlertDialog alert;
    RecyclerView news_recyclerview;
    ApiInterface apiInterface;
    NewsCardAdapter newsCardAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_);
        news_recyclerview=findViewById(R.id.news_rc);
        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        LinearLayoutManager lm = new LinearLayoutManager(this);
        news_recyclerview.setLayoutManager(lm);
        String option ="top_country";
        getNews(option);
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setTitle("Exit Application");
        builder.setMessage("Do you want to exit?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        alert=builder.create();
    }

    @Override
    public void onBackPressed() {
        count++;
        if (count < 2) {
            Toast.makeText(getApplicationContext(), "Please back again to exit", Toast.LENGTH_SHORT).show();
        } else {
            finish();
        }
        Handler h = new Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                count = 0;
            }
        }, 1000);
    }

    private void getNews(String option) {
        ProgressDialog progress = new ProgressDialog(this);
        progress.setMessage("Loading News");
        progress.show();
        Call<NewsData> call = null;
        switch (option){
            case "top_country": call = apiInterface.getNewsDataByCountry("in","caa499b2e6c24924b338c495a2a7a497");
            break;
            case "top_category": call = apiInterface.getNewsDataByCategory("sports","caa499b2e6c24924b338c495a2a7a497");
                    break;
            case "everything_cat": call = apiInterface.getNewsDataByCategoryFromEverything("in","caa499b2e6c24924b338c495a2a7a497");
                break;
            case "everything_country": call = apiInterface.getNewsDataByCountryFromEverything("sports","caa499b2e6c24924b338c495a2a7a497");
                break;
        }


        call.enqueue(new Callback<NewsData>() {
            @Override
            public void onResponse(Call<NewsData> call, Response<NewsData> response) {
                if(response.body().getStatus().equals("ok")){
                    List<News> mynews = response.body().getAllNews();
                    newsCardAdapter = new NewsCardAdapter(mynews,News_Activity.this);
                    news_recyclerview.setAdapter(newsCardAdapter);
                    progress.cancel();
                }
            }

            @Override
            public void onFailure(Call<NewsData> call, Throwable t) {

            }
        });

    }
}