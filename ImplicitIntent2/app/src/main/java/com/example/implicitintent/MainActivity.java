package com.example.implicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.net.URI;

public class MainActivity extends AppCompatActivity {
Button b;
EditText input;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b=findViewById(R.id.button);
        input=findViewById(R.id.msg);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String num=input.getText().toString();
                Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse("sms:"+num));
                startActivity(i);
            }
        });
    }
}