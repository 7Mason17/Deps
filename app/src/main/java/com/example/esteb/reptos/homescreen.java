package com.example.esteb.reptos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class homescreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);

        final TextView welcomeMessage = (TextView) findViewById(R.id.tvWelcomeMessage);
        final Button profile = (Button) findViewById(R.id.profileB);


        Intent intent = getIntent();
        final String fName = intent.getStringExtra("Fname");
        final String lName = intent.getStringExtra("Lname");
        final String bEmail = intent.getStringExtra("email");
        final String zipcode = intent.getStringExtra("zipcode");
        final String password = intent.getStringExtra("password");


        String message = fName + "welcome to yoru user area";
        welcomeMessage.setText(message);

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(homescreen.this, profileScreen.class);
                intent.putExtra("Fname", fName);
                intent.putExtra("Lname", lName);
                intent.putExtra("email", bEmail);
                intent.putExtra("zipcode", zipcode);
                intent.putExtra("password", password);
                homescreen.this.startActivity(intent);
            }
        });
    }
}
