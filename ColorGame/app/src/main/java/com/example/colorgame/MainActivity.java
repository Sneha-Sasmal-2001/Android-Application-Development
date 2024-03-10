package com.example.colorgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView count_tv,score_tv,color_tv;
    Button red_b,green_b,blue_b,cyan_b,magenta_b,yellow_b,start_b;
    String colors[] = {"red","green","blue","cyan","magenta","yellow"};
    String selectedColor="";
    int score=0;
    boolean gameRunning = false;
    Random random;
    Handler h;
    int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        count_tv = findViewById(R.id.count);
        score_tv = findViewById(R.id.score);
        color_tv = findViewById(R.id.color);

        red_b = findViewById(R.id.red);
        green_b = findViewById(R.id.green);
        blue_b = findViewById(R.id.blue);
        cyan_b = findViewById(R.id.cyan);
        magenta_b = findViewById(R.id.magenta);
        yellow_b = findViewById(R.id.yellow);

        start_b = findViewById(R.id.start);

        random = new Random();
        h = new Handler();

        start_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gameRunning = true;
                count = 0;
                score= 0;
                count_tv.setText(" Count: "+count+"/20");
                score_tv.setText("Score: 0");
                start_b.setEnabled(false);
                startGame();
            }
        });

    }

    private void startGame() {
        count++;
        if(count>20){
            gameRunning = false;
            start_b.setEnabled(true);
            if(score<10)
                color_tv.setText("You are a Noob");
            else if(score<15)
                color_tv.setText("You are a Leaner");
            else
                color_tv.setText("You are a Pro");
            return;
        }
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                int i = random.nextInt(100)%6;//for making more chances for having large samplespace so that same colour doesn't come twice
                selectedColor = colors[i];
                color_tv.setText(colors[i]);
                count_tv.setText(" Count: "+count+"/20");
                startGame();
            }
        }, 1000);

    }

    public void onclick(View v){
        if(gameRunning == false){
            return;
        }
        String col="";
        switch (v.getId()){
            case R.id.red: col="red";
                break;
            case R.id.green:col="green";
                break;
            case R.id.blue:col="blue";
                break;
            case R.id.cyan:col="cyan";
                break;
            case R.id.magenta:col="magenta";
                break;
            case R.id.yellow:col="yellow";
                break;
        }
        //Toast.makeText(getApplicationContext(), col, Toast.LENGTH_SHORT).show();
        Log.e("Cols",selectedColor+"--"+col+"--"+score);
        if(selectedColor.equals(col)){
            score++;
            score_tv.setText("Score: "+score);
        }
        selectedColor="";
    }

}