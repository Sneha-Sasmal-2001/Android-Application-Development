package com.example.knowtogrow;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.knowtogrow.pojoclass.News;
import com.example.knowtogrow.pojoclass.NewsData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class News_Activity extends AppCompatActivity {
    RecyclerView news_recyclerview;
    ApiInterface apiInterface;
    NewsCardAdapter newsCardAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_);
        news_recyclerview=findViewById(R.id.news_rc);
        apiInterface = com.example.knowtogrow.ApiClient.getApiClient().create(ApiInterface.class);
        LinearLayoutManager lm = new LinearLayoutManager(this);
        news_recyclerview.setLayoutManager(lm);
        Intent i = getIntent();
        String option =i.getStringExtra("option")!=null?i.getStringExtra("option"):"top_country";
        String category = i.getStringExtra("category")!=null?i.getStringExtra("category"):"";
        Log.e("Cat",category);
        getNews(option,category);

    }
    private void getNews(String option, String category) {
        ProgressDialog progress = new ProgressDialog(this);
        progress.setMessage("Loading News");
        progress.show();
        Call<NewsData> call = null;
        switch (option){
            case "top-country": call = apiInterface.getNewsDataByCountry("in","caa499b2e6c24924b338c495a2a7a497");
            break;
            case "top-category": call = apiInterface.getNewsDataByCategory(category,"caa499b2e6c24924b338c495a2a7a497");
                    break;
            case "everything_cat": call = apiInterface.getNewsDataByCategoryFromEverything(category,"caa499b2e6c24924b338c495a2a7a497");
                break;
        }


        call.enqueue(new Callback<NewsData>() {
            @Override
            public void onResponse(Call<NewsData> call, Response<NewsData> response) {
                if(response.body().getStatus().equals("ok")){
                    List<News> mynews = response.body().getAllNews();
                    newsCardAdapter = new NewsCardAdapter(mynews, com.example.knowtogrow.News_Activity.this);
                    news_recyclerview.setAdapter(newsCardAdapter);
                    progress.cancel();
                }
            }

            @Override
            public void onFailure(Call<NewsData> call, Throwable t) {

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent i= new Intent(News_Activity.this,Preferences.class);
        startActivity(i);
        finish();
        return super.onOptionsItemSelected(item);
    }
}