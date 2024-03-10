package com.example.knowtogrow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.util.ULocale;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.GridView;

import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.Locale;

public class Preferences extends AppCompatActivity {
    GridView cat;
    EditText search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences);

        cat = findViewById(R.id.topic);
        search = findViewById(R.id.searchtext);
        TextInputLayout searchLay=findViewById(R.id.outlinedTextField);
        ArrayList<Category> categoryArrayList = new ArrayList<Category>();
       categoryArrayList.add(new Category("Sports", R.drawable.sports));
      categoryArrayList.add(new Category("Politics", R.drawable.politics));
       categoryArrayList.add(new Category("Business", R.drawable.business));
       categoryArrayList.add(new Category("Education", R.drawable.education));
       categoryArrayList.add(new Category("Entertainment", R.drawable.entertainment));
       categoryArrayList.add(new Category("Trending", R.drawable.trending));


       CategoryAdapter adapter = new CategoryAdapter(this,categoryArrayList);
        cat.setAdapter(adapter);

        searchLay.setEndIconOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = search.getText().toString();
                Intent i = new Intent(Preferences.this,News_Activity.class);
                i.putExtra("option","everything_cat");
                i.putExtra("category",s.toUpperCase());
                startActivity(i);
            }
        });
    }
}