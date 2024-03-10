package com.example.studentregistrationform;

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
        EditText name,email,phone,dob;
        Button register;
        CheckBox check;
        RadioGroup gender;

        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.phone);
        dob = findViewById(R.id.dob);
        register = findViewById(R.id.register);
        gender = findViewById(R.id.gender);
        check = findViewById(R.id.checkBox);

        check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    register.setEnabled(true);
                else
                    register.setEnabled(false);
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n = name.getText().toString();
                String e = email.getText().toString();
                String p = phone.getText().toString();
                String d = dob.getText().toString();
                String g = ""; // R.id.genM , R.id.genF , R.id.genT
                switch (gender.getCheckedRadioButtonId()) {
                    case R.id.genM:
                        g = "Male";
                        break;
                    case R.id.genF:
                        g = "Female";
                        break;
                    case R.id.genT:
                        g = "Transgender";
                }

                if (n.length() == 0) {
                    name.setError("Please Enter Name");
                    name.requestFocus();
                    return;
                }
                String em="";
                boolean flag_email = false;
                if (e.length() == 0) {
                    em = "Please Enter Email";
                    flag_email = true;
                } else if (e.indexOf('@') == -1){
                    em = "There should be @ in email";
                    flag_email = true;
                }
                else if(e.indexOf('@')<2){
                    em = "Invalid email address";
                    flag_email = true;
                }
                else if(e.lastIndexOf('.') == -1 || (e.length()-e.lastIndexOf('.'))<3){
                    em = "No Domain Present";
                    flag_email = true;
                }
                if(flag_email) {
                    email.setError(em);
                    email.requestFocus();
                    return;
                }
                if(p.length() == 0){
                    phone.setError("Please Enter Phone");
                    phone.requestFocus();
                    return;
                }
                if(d.length() == 0){
                    dob.setError("Please Enter DOB");
                    dob.requestFocus();
                    return;
                }
                if(g.length() == 0){
                    Toast.makeText(getApplicationContext(), "Please Select Gender", Toast.LENGTH_SHORT).show();;
                    gender.requestFocus();
                    return;
                }


                String ans = "Name: "+n
                        +"\nEmail: "+e
                        +"\nPhone: "+p
                        +"\nDob: "+d
                        +"\nGender: "+g;
                Toast.makeText(getApplicationContext(), ans, Toast.LENGTH_SHORT).show();
            }
        });



    }
}