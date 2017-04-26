package com.example.esteb.reptos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

public class profileScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_screen);

        Intent intent = getIntent();
        final String fName = intent.getStringExtra("Fname");
        final String lName = intent.getStringExtra("Lname");
        final String bEmail = intent.getStringExtra("email");
        final String zipcode = intent.getStringExtra("zipcode");
        final String password = intent.getStringExtra("password");


        final EditText first_name = (EditText) findViewById(R.id.etFirst);
        final EditText last_name = (EditText) findViewById(R.id.etLast);
        final EditText email = (EditText) findViewById(R.id.etEmail);
        final EditText zip = (EditText) findViewById(R.id.etZipcode);
        final EditText pass = (EditText) findViewById(R.id.etPassword);


        first_name.setText(fName);
        last_name.setText(lName);
        email.setText(bEmail);
        zip.setText(zipcode);
        pass.setText(password);
    }
}
