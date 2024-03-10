package com.example.animation;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView im;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        im = findViewById(R.id.imageView);
    }

    public void zoom(View v){
        Animation anim = new ScaleAnimation(1f,2f,1f,2f,
                im.getPivotX(),im.getPivotY());
        anim.setDuration(2000);
        //anim.setFillAfter(true);
        anim.setRepeatCount(Animation.INFINITE);
        anim.setRepeatMode(Animation.REVERSE);
        im.startAnimation(anim);
    }
    public void fade(View v){
        Animation anim = new AlphaAnimation(0f,1f);
        anim.setDuration(2000);
        //anim.setFillAfter(true);
        anim.setRepeatCount(Animation.INFINITE);
        anim.setRepeatMode(Animation.REVERSE);
        im.startAnimation(anim);

    }
    public void blink(View v){
        Animation anim = new AlphaAnimation(0f,1f);
        anim.setDuration(2000);
        //anim.setFillAfter(true);
        anim.setRepeatCount(Animation.INFINITE);
        //anim.setRepeatMode(Animation.REVERSE);
        im.startAnimation(anim);
    }
    public void rotate(View v){
        Animation anim = new RotateAnimation(0,360,im.getPivotX(),im.getPivotY());
        anim.setDuration(2000);
        //anim.setFillAfter(true);
        anim.setRepeatCount(Animation.INFINITE);
        anim.setRepeatMode(Animation.REVERSE);
        im.startAnimation(anim);
    }
    public void move(View v){
        Animation anim = new TranslateAnimation(0,200,0,200);
        anim.setDuration(2000);
        //anim.setFillAfter(true);
        anim.setRepeatCount(Animation.INFINITE);
        anim.setRepeatMode(Animation.REVERSE);
        im.startAnimation(anim);
    }
    public void custom(View v){
        //have a ball and bounce to four sides


        
    }

}