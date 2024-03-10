package com.example.loginform;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b;
        CheckBox check;
        EditText name, email, pass, university;
        RadioGroup year;

        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        pass = findViewById(R.id.password);
        university = findViewById(R.id.university);
        check = findViewById(R.id.check);
        b = findViewById(R.id.login);
        year = findViewById(R.id.year);
        check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                             @Override
                                             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                                 if (isChecked)
                                                     b.setEnabled(true);
                                                 else
                                                     b.setEnabled(false);
                                             }
                                         }
        );
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n = name.getText().toString();
                String e = email.getText().toString();
                String p = pass.getText().toString();
                String u = university.getText().toString();
                String y = ""; // R.id.first , R.id.second , R.id.third
                switch (year.getCheckedRadioButtonId()) {
                    case R.id.first:
                        y = "1st";
                        break;
                    case R.id.second:
                        y = "2nd";
                        break;
                    case R.id.third:
                        y = "3rd";
                }
                if (n.length() == 0) {
                    name.setError("Please Enter Name");
                    name.requestFocus();
                    return;
                    if (p.length() == 0) {
                        pass.setError("Please Enter Password");
                        pass.requestFocus();
                        return;
                    }
                        if (u.length() == 0) {
                            university.setError("Please Enter Name");
                            university.requestFocus();
                            return;

                            if (y.length() == 0) {
                                Toast.makeText(getApplicationContext(), "Please Select Year", Toast.LENGTH_SHORT).show();
                                ;
                                year.requestFocus();
                                return;


                            }
                        }
                        String ans = "Name: " + n
                                + "\nEmail: " + e
                                + "\nPassword: " + p
                                + "\nUniversity: " + u
                                + "\nYear: " + year;
                        Toast.makeText(getApplicationContext(), ans, Toast.LENGTH_SHORT).show();


                    }
                }
            }
        });
    }