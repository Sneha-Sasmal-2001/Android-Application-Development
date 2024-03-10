package com.example.seekbar2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    SeekBar s;
    TextView t;
    boolean accept;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        s=findViewById(R.id.seekBar);
        t=findViewById(R.id.textView);
        AlertDialog.Builder alert=new AlertDialog.Builder(this);
        alert.setTitle("Too Large");
        alert.setMessage("do you want to keep it?");
        alert.setCancelable(false);
        alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                t.setTextSize(30);
                s.setProgress(17);
            }
        });
        alert.setPositiveButton("Sure", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                accept=false;
            }
        });
        
    }
}