package com.example.lifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("LifeCycle","OnCreate Invoked");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("LifeCycle","OnStart Invoked");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("LifeCycle","OnResume Invoked");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("LifeCycle","OnPause Invoked");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("LifeCycle","OnStop Invoked");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("LifeCycle","OnRestart Invoked");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("LifeCycle","OnDestroy Invoked");
    }
}
