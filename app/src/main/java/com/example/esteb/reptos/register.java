package com.example.esteb.reptos;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by esteb on 4/25/2017.
 */

public class register extends StringRequest{
    private static final String REGISTER_REQUEST_URL = "http://146.148.103.129/register.php";
    private Map<String, String> params;

    public register(String fName, String lName, String email, String zipcode, String password, Response.Listener<String> listener)
    {
        super(Method.POST, REGISTER_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("fname", fName);
        params.put("lname", lName);
        params.put("email", email);
        params.put("zipcode", zipcode);
        params.put("password", password);
    }

    @Override
    public Map<String, String> getParams()
    {
        return params;
    }
}
