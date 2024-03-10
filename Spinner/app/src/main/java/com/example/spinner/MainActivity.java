package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String arr[] = {"---Select Department---","CSE","ECE","MECH","ELECTRICAL"};
    String arr2[] = {"---Select Semester---","I","II","III","IV"};
    Spinner s1,s2;
    String dept="",sem="";
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        s1 = findViewById(R.id.spinner);
        s2 = findViewById(R.id.spinner2);
        b = findViewById(R.id.button);


        ArrayAdapter adp = new ArrayAdapter(this, android.R.layout.simple_spinner_item,arr);
        adp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s1.setAdapter(adp);

        ArrayAdapter adp2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item,arr2);
        adp2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s2.setAdapter(adp2);

        s1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0) {
                    dept = "";
                    return;
                }
                dept = arr[position];
                Toast.makeText(getApplicationContext(), dept, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        s2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0) {
                    sem = "";
                    return;
                }
                sem = arr2[position];
                Toast.makeText(getApplicationContext(), sem, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dept.length()==0){
                    Toast.makeText(getApplicationContext(), "Please Choose Department", Toast.LENGTH_SHORT).show();
                    s1.performClick();
                    return;
                }
                if(sem.length()==0){
                    Toast.makeText(getApplicationContext(), "Please Choose Semester", Toast.LENGTH_SHORT).show();
                    s2.performClick();
                    return;
                }

                if(dept=="CSE" && sem=="IV"){
                    Toast.makeText(getApplicationContext(), "Your Result is Published", Toast.LENGTH_SHORT).show();
                }
                else if(dept=="MECH" && sem=="II"){
                    Toast.makeText(getApplicationContext(), "Your Result is Published", Toast.LENGTH_SHORT).show();
                }
                else if(dept=="ECE" && sem=="III"){
                    Toast.makeText(getApplicationContext(), "Your Result is Published", Toast.LENGTH_SHORT).show();
                }
                else if(dept=="ELECTRICAL" && sem=="I"){
                    Toast.makeText(getApplicationContext(), "Your Result is Published", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Your Result is Not Published", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

}