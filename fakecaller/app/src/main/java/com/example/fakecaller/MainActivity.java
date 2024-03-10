package com.example.fakecaller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.net.URI;

public class MainActivity extends AppCompatActivity {
EditText ph_number;
Button call_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        call_btn=findViewById(R.id.call);
        ph_number=findViewById(R.id.number);


        call_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str_num = ph_number.getText().toString();
                Intent i = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + str_num));
                if (str_num.length() == 0) {
                    ph_number.setError("Please Enter Number");  //if no number is given then show error
                    ph_number.requestFocus();
                } else {
                    startActivity(i);
                }

                if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(MainActivity.this, "Please Grant Permission", Toast.LENGTH_SHORT).show();
                    request_permission();
                } else {
                    startActivity(i);
                }

            }

        });


        }


        private void request_permission()
        {
            ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.CALL_PHONE},1); //if permission not granted then grant it
    }
}