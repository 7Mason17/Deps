package com.example.esteb.reptos;


import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by esteb on 4/25/2017.
 */

public class login extends StringRequest
{
    private static final String LOGIN_REQUEST_URL = "http://146.148.103.129/login.php";
    private Map<String, String> params;

    public login(String email, String password, Response.Listener<String> listener) {
        super(Method.POST, LOGIN_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("email", email);
        params.put("password", password);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
