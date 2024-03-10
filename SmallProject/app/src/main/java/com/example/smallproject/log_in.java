package com.example.smallproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class log_in extends AppCompatActivity {
EditText user_id, password;
Button login, signin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        user_id=findViewById(R.id.email);
        password=findViewById(R.id.password);
        login=findViewById(R.id.login);
        signin=findViewById(R.id.signin);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id=user_id.getText().toString();
                String pass=password.getText().toString();

  /*           if(id!=email_id)
                {
                  user_id.setError("Please enter email which already has a account here");
                  user_id.requestFocus();
                  return;
                }
                else if (pass!=password)
                {
                    password.setError("Please enter password of your existing account");
                    password.requestFocus();
                    return;
                }                                                                                   */
                Intent i = new Intent(log_in.this, DownloadActivity.class);
                startActivity(i);
                finish();
            }
        });
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1= new Intent(log_in.this,create_account.class);
                startActivity(i1);
                finish();
            }
        });

    }
}