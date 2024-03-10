package com.example.projectdraft1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Register_page extends AppCompatActivity {
     Button confirm_b;
    private FirebaseAuth mAuth;
    EditText name_t,email_t,phone_t,password_t,conf_pass_t,dob_t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);
        confirm_b=findViewById(R.id.register);
        mAuth = FirebaseAuth.getInstance();
        name_t=findViewById(R.id.name);
        email_t=findViewById(R.id.email);
        phone_t=findViewById(R.id.phone);
        password_t=findViewById(R.id.password);
        conf_pass_t=findViewById(R.id.conf_password);
        dob_t=findViewById(R.id.dob);

        confirm_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              String  em=email_t.getText().toString();
              String  ps=password_t.getText().toString();
              String  conf_ps=conf_pass_t.getText().toString();
              String  dob=dob_t.getText().toString();
              String  n=name_t.getText().toString();
              String  phone=phone_t.getText().toString();
                if (n.length() == 0) {
                    name_t.setError("Please Enter Name");
                    name_t.requestFocus();
                    return;
                }
                String e="";
                boolean flag_email = false;
                if (em.length() == 0) {
                    e = "Please Enter Email";
                    flag_email = true;
                } else if (em.indexOf('@') == -1){
                    e = "There should be @ in email";
                    flag_email = true;
                }
                else if(em.indexOf('@')<2){
                    e= "Invalid email address";
                    flag_email = true;
                }
                else if(em.lastIndexOf('.') == -1 || (em.length()-e.lastIndexOf('.'))<3){
                    e = "No Domain Present";
                    flag_email = true;
                }
                if(flag_email) {
                    email_t.setError(e);
                    email_t.requestFocus();
                    return;
                }
                if(phone.length() <10){
                    phone_t.setError("Please Enter Phone");
                    phone_t.requestFocus();
                    return;
                }
                if(dob.length() == 0){
                    dob_t.setError("Please Enter DOB");
                    dob_t.requestFocus();
                    return;
                }
                if(!conf_ps.equals(ps)){
                    conf_pass_t.setError("Please re-enter given password");
                    conf_pass_t.requestFocus();
                    return;
                }
                mAuth.createUserWithEmailAndPassword(em, ps)
                        .addOnCompleteListener(Register_page.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                   // Log.d(TAG, "createUserWithEmail:success");
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    Toast.makeText(Register_page.this, "Registration successfully completed.", Toast.LENGTH_SHORT).show();
                                    Intent i= new Intent(Register_page.this,LogIn.class);
                                    startActivity(i);
                                    finish();
                                   // updateUI(user);
                                } else {
                                    // If sign in fails, display a message to the user.
                                 //   Log.w(TAG, "createUserWithEmail:failure", );
                                    Toast.makeText(Register_page.this, "Authentication failed."+task.getException(),
                                            Toast.LENGTH_LONG).show();
                                    Log.e("Failure",task.getException().toString());
                                   //updateUI(null);
                                }
                            }
                        });


            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.help,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.report:
                Intent i= new Intent(Intent.ACTION_VIEW, Uri.parse("https://fb.com/sneha sasmal"));
                startActivity(i);
                break;
            case R.id.about_us:
                Intent i1= new Intent(Intent.ACTION_DIAL, Uri.parse("tel:7003946623"));
                startActivity(i1);
                break;
            case R.id.help: finish();
        }
        return super.onOptionsItemSelected(item);

    }

    public void back_page(View v){

        Intent i= new Intent(Register_page.this,LogIn.class);
        startActivity(i);
        finish();
    }
}