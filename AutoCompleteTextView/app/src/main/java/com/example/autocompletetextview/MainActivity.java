package com.example.autocompletetextview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    String sport[] = {"Cricket","Carrom","Football","FootCricket","Hockey","Tennis","Chess","Handball","Twitch"};
    AutoCompleteTextView actv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        actv = findViewById(R.id.autoCompleteTextView);

        ArrayAdapter adp = new ArrayAdapter(this, android.R.layout.simple_list_item_1,sport);

        actv.setAdapter(adp);
        actv.setThreshold(1);


    }
}