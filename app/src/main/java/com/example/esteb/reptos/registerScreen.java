package com.example.esteb.reptos;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class registerScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_screen);

        final EditText etfirst_name = (EditText) findViewById(R.id.fisrt);
        final EditText etlast_name = (EditText) findViewById(R.id.last);
        final EditText etemail = (EditText) findViewById(R.id.email);
        final EditText etzipcode = (EditText) findViewById(R.id.zip);
        final EditText etpassword = (EditText) findViewById(R.id.pass);
        final Button bRegister = (Button) findViewById(R.id.RegisterButton);


        bRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String firstname = etfirst_name.getText().toString();
                final String lastname = etlast_name.getText().toString();
                final String email = etemail.getText().toString();
                final String zipcode = etzipcode.getText().toString();
                final String password = etpassword.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if(success)
                            {
                                Intent intent = new Intent(registerScreen.this, frontpage.class);
                                registerScreen.this.startActivity(intent);
                            }
                            else
                            {
                                AlertDialog.Builder builder = new AlertDialog.Builder(registerScreen.this);
                                builder.setMessage("Register Failed")
                                        .setNegativeButton("Retry", null)
                                        .create()
                                        .show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                };


                register Register = new register(firstname, lastname, email, zipcode, password, responseListener);
                RequestQueue queue = Volley.newRequestQueue(registerScreen.this);
                queue.add(Register);
            }
        });

    }
}
