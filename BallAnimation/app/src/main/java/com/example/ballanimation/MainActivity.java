package com.example.ballanimation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView im;
    Button b;
    int ball;
    View rl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b=findViewById(R.id.button);
        im=findViewById(R.id.imageView);
        rl=findViewById(R.id.layout);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int x = rl.getWidth();
                int y=rl.getWidth();
                Animation anime=new TranslateAnimation(0,(x/2)-100,0,(y/2)-150);//(0,0)
                anime.setDuration(2000);//takes time to go from one point to another
                anime.setFillAfter(true);

                Animation anime1=new TranslateAnimation((x/2)-100,0f,(y/2)-150,y);
                anime1.setDuration(2000);//takes time to go from one point to another
                anime1.setFillAfter(true);

                Animation anime2=new TranslateAnimation(0f,-(x/2)-100,y,-(y/2)-150);
                anime2.setDuration(2000);//takes time to go from one point to another
                anime2.setFillAfter(true);


                Animation anime3=new TranslateAnimation(-(x/2)-100,0f,-(y/2)-150,0f);
               anime3.setDuration(2000);
                anime3.setFillAfter(true);
                anime.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                    im.startAnimation(anime1);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                anime1.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        im.startAnimation(anime2);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                anime2.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        im.startAnimation(anime3);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });



            }
        });
    }

}