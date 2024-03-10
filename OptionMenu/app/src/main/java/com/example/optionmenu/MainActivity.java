package com.example.optionmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       getMenuInflater().inflate(R.menu.first_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.about_us:
                Intent i= new Intent(Intent.ACTION_VIEW, Uri.parse("https://fb.com/sneha sasmal"));
                startActivity(i);
                break;
            case R.id.contact:
                Intent i1= new Intent(Intent.ACTION_DIAL, Uri.parse("tel:7003946623"));
                startActivity(i1);
                break;
            case R.id.exit: finish();
        }

        return super.onOptionsItemSelected(item);
    }
}