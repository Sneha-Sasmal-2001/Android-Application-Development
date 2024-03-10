package com.example.smallproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class create_account extends AppCompatActivity {
    EditText name, email_id,phone,password,confirm_password;
    Button confirm_b,cancel_b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        name=findViewById(R.id.name);
        email_id=findViewById(R.id.email_id);
        phone=findViewById(R.id.phone);
        password=findViewById(R.id.password);
        confirm_password=findViewById(R.id.confirm_password);
        confirm_b=findViewById(R.id.confirm_b);
        cancel_b=findViewById(R.id.cancel_b);

        confirm_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n = name.getText().toString();
                String e = email_id.getText().toString();
                String p = phone.getText().toString();
                String pass = password.getText().toString();
                String conf_pass = confirm_password.getText().toString();
                if(n.length()==0)
                {
                    name.setError("Please enter your name");
                    name.requestFocus();
                    return;
            }
                String em="";
                boolean flag_email= false;
                if(e.length()==0)
                {
                  em="Please enter your e-mail id";
                  flag_email=true;
                }
                else if(e.indexOf('@')==-1)
                {
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
                    email_id.setError(em);
                    email_id.requestFocus();
                    return;
                }

                if(p.length()<10)
                {
                    phone.setError("Please enter valid phone number");
                    phone.requestFocus();
                    return;
                }
                String pw="";
                boolean flag_pass=false;
                if(pass.length()<8) {
                    pw = "Minimum length of your password should be 8";
                    flag_pass = true;
                }
                    if(flag_pass)
                    {
                    password.setError(pw);
                    password.requestFocus();
                    return;
                }
                if(pass!=conf_pass)
                {
                    confirm_password.setError("Please confirm your given password");
                    confirm_password.requestFocus();
                    return;
                }
                String ans = "Name: "+n
                        +"\nEmail: "+e
                        +"\nPhone: "+p
                        +"\nPassword: "+pass;
                Toast.makeText(getApplicationContext(), ans, Toast.LENGTH_SHORT).show();
        }

    });
    cancel_b.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i= new Intent(create_account.this,log_in.class);
            startActivity(i);
            finish();
        }
    });
}
}