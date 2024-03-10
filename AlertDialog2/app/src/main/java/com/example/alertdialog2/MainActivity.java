package com.example.alertdialog2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
AlertDialog alert;
    int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //step 1: building the alert dialog interface
    android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);

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
//double back press make the app close
@Override
public void onBackPressed() {
count++;
        if(count<2){
            Toast.makeText(getApplicationContext(), "Please back again to exit", Toast.LENGTH_SHORT).show();
    }
        else {
            finish();
        }
    Handler h=new Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                count=0;
            }
        }, 1000);

        }
        }