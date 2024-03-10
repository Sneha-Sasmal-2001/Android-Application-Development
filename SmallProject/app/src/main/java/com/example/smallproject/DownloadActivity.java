package com.example.smallproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Random;

public class DownloadActivity extends AppCompatActivity {
    TextView t;
ProgressBar pb;
Button b3,b4;
int downsize=0;
int filesize=1500;
boolean pause,download;
Random r;
Handler h;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);
        pb=findViewById(R.id.progressBar);
        b3=findViewById(R.id.button3);
        b4=findViewById(R.id.button4);
        h=new Handler();
        r=new Random();
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(download==true)
                {
                    download=false;
                    downsize = 0;
                    pb.setProgress(0);
                    t.setText("0% downloaded");
                    doDownload();
                    b3.setText("Download");
                    b4.setEnabled(true);

                }
                else
                {
                    download=true;
                    b3.setText("Cancel");
                    b4.setEnabled(false);
                    downsize = 0;
                    pb.setProgress(0);
                    doDownload();
                }
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(pause==true)
                {
                    pause=false;
                    doDownload();
                    b4.setText("Resume");
                }
                else
                {

                    pause=true;

                    b4.setText("Pause");
                }
            }
        });


    }
    private void doDownload()
    {
        if(pause == true){
            return;
        }

        if(downsize==filesize || download==false) {
            b3.setEnabled(true);
            b3.setText("Download");
          b4.setEnabled(false);
            return;
        }
        int x=r.nextInt(100);// it'll give random numbers from 0-99
        downsize+=x;
        if(downsize>filesize)
            downsize = filesize;
       float y= downsize/filesize*100;
       t.setText(String.format("%.2f",y)+"% download");
        pb.setProgress((int)y);
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                doDownload();
            }
        }, 1000);

    }
}