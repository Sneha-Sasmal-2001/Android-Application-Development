package com.example.implicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText input;
    Button call,visit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = findViewById(R.id.input);
        call = findViewById(R.id.button);
        visit = findViewById(R.id.button2);

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num =  input.getText().toString();
                Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+num));
                startActivity(i);
            }
        });

        visit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = input.getText().toString();
                Intent i = new Intent(Intent.ACTION_VIEW,Uri.parse(url));
                startActivity(i);
            }
        });

    }
}