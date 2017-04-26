package com.example.esteb.reptos;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class frontpage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frontpage);

        final EditText etEmail = (EditText) findViewById(R.id.email);
        final EditText etPassword = (EditText) findViewById(R.id.password);
        final Button bLogin = (Button) findViewById(R.id.loginButton);
        final TextView tvRegister = (TextView) findViewById(R.id.tvRegister);



        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerintent = new Intent(frontpage.this, registerScreen.class);
                frontpage.this.startActivity(registerintent);
            }
        });





        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email = etEmail.getText().toString();
                final String password = etPassword.getText().toString();

                // Response received from the server
                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");

                            if (success) {
                                String fName = jsonResponse.getString("Fname");
                                String lName = jsonResponse.getString("Lname");
                                String bEmail = jsonResponse.getString("email");
                                String zipCode = jsonResponse.getString("Zipcode");
                                String password = jsonResponse.getString("password");

                                Intent intent = new Intent(frontpage.this, homescreen.class);
                                intent.putExtra("Fname", fName);
                                intent.putExtra("Lname", lName);
                                intent.putExtra("email", bEmail);
                                intent.putExtra("zipcode", zipCode);
                                intent.putExtra("password", password);
                                frontpage.this.startActivity(intent);
                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(frontpage.this);
                                builder.setMessage("Login Failed")
                                        .setNegativeButton("Retry", null)
                                        .create()
                                        .show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                login loginRequest = new login(email, password, responseListener);
                RequestQueue queue = Volley.newRequestQueue(frontpage.this);
                queue.add(loginRequest);
            }
        });
    }
}