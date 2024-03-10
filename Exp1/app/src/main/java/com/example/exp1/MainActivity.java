package com.example.exp1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
int count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button chiku,b2;
        TextView txt;
        count=0;
        chiku = findViewById(R.id.button1);
        b2 = findViewById(R.id.button2);
        txt = findViewById(R.id.text);

        chiku.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             count++;
txt.setText("button clicked"+count);
            }
        });
    }
}