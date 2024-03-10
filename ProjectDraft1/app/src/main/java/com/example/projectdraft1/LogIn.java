package com.example.projectdraft1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.SharedElementCallback;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LogIn extends AppCompatActivity {
    Button login_b,register_b;
    private FirebaseAuth mAuth;
    EditText user_t,pass_t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        login_b=findViewById(R.id.login);
        register_b=findViewById(R.id.register);
        user_t=findViewById(R.id.username);
        pass_t=findViewById(R.id.login_password);

        login_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user=user_t.getText().toString();
                String login_pass=pass_t.getText().toString();
                mAuth.signInWithEmailAndPassword(user, login_pass)
                        .addOnCompleteListener(LogIn.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                   // Log.d(TAG, "signInWithEmail:success");
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    Toast.makeText(LogIn.this, "logged in", Toast.LENGTH_LONG).show();

                                   // updateUI(user);
                                } else {
                                    // If sign in fails, display a message to the user.
                                  //  Log.w(TAG, "signInWithEmail:failure", task.getException());
                                    Toast.makeText(LogIn.this, "Authentication failed."+task.getException(),
                                            Toast.LENGTH_LONG).show();
                                    //updateUI(null);
                                }
                            }
                        });
                Toast.makeText(getApplicationContext(), "LOG IN", Toast.LENGTH_LONG).show();
            }
        });
        register_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(), "REGISTER", Toast.LENGTH_LONG).show();
                Intent i= new Intent(LogIn.this,Register_page.class);
                startActivity(i);
                finish();
            }
        });

    }

    public void mainPage(View v){
        Intent i = new Intent(LogIn.this,News_Activity.class);
        startActivity(i);
        finish();
    }
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
      /*  FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Intent i= new Intent(LogIn.this,Welcome.class);
            startActivity(i);
            finish();
        }*/
    }


}