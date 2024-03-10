package com.example.progressbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ProgressBar pb;
    Button b,b1,b2;
    int fileSize = 10000;
    float downSize = 0;
    TextView t;
    Handler h;
    Random r;
    boolean cancelled,pause;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pb = findViewById(R.id.progressBar);
        b = findViewById(R.id.button);
        b1 = findViewById(R.id.button2);
        b2 = findViewById(R.id.button3);
        t = findViewById(R.id.textView);
        r = new Random();
        h = new Handler();

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                downSize = 0;
                cancelled = false;
                t.setText("0% downloaded");
                pb.setProgress(0);
                doDownload();
                b.setEnabled(false);
            }
        });


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelled = true;
                t.setText("Download Canceled");
                b.setEnabled(true);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pause == true){
                    pause = false;
                    doDownload();
                    b2.setText("Pause");
                }
                else
                {
                    pause = true;
                    b2.setText("Resume");
                }
            }
        });


    }

    private void doDownload() {
        if(pause == true){
            return;
        }
        if(downSize==fileSize || cancelled == true) {
            b.setEnabled(true);
            return;
        }
        int x = r.nextInt(501)+500; // generates random number between 500 - 1000
        downSize += x;    //this means: downSize = downSize + x;
        if(downSize>fileSize)
            downSize = fileSize;
        float y = downSize/fileSize*100;   // 0.05 -> 0.05*100 -> 5.0
        t.setText(String.format("%.2f",y)+"% downloaded");
        pb.setProgress((int)y);
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                doDownload();
            }
        }, 1000);

        //Toast.makeText(this, "Download "+y, Toast.LENGTH_SHORT).show();
    }
}