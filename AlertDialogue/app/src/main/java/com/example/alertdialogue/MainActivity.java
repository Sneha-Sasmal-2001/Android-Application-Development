package com.example.alertdialogue;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    AlertDialog alert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //step 1: building the alert dialog interface
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Exit Application");
        builder.setMessage("Do you want to exit?");
        builder.setCancelable(false);
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        //step2: setting up the alert window to launch
        alert = builder.create();
        //alert.show();
    }

    @Override
    public void onBackPressed() {
        alert.show();
    }
}