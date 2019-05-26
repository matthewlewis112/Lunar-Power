package edu.calpoly.lunarpower;

import android.content.Context;
import android.util.Base64;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class NetworkService {

    private static final String BASE_URL = "http://192.168.1.36:5000";

    private static NetworkService instance;
    private RequestQueue queue;
    private String username;
    private String password;

    private NetworkService(Context context) {
        queue = Volley.newRequestQueue(context);
    }

    public static NetworkService createAndValidateInstance(Context context, String username, String password, Callback<Object> callback) {
        if (instance == null) {
            instance = new NetworkService(context);
        }
        instance.username = username;
        instance.password = password;
        instance.doRequest("", callback);
        return instance;
    }

    public static NetworkService getInstance() {
        return instance;
    }

    public <T> void doRequest(String endpoint, final Callback<T> callback) {
        StringRequest request = new StringRequest
                (Request.Method.GET, BASE_URL, new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        callback.onSucceed(new Gson().fromJson(response,callback.getEntityType()));
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        callback.onFailure(error);

                    }
                }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headers = new HashMap<>();
                String credentials = username + ":" + password;
                String auth = "Basic "
                        + Base64.encodeToString(credentials.getBytes(), Base64.NO_WRAP);
                headers.put("Content-Type", "application/json");
                headers.put("Authorization", auth);
                return headers;
            }
        };
        queue.add(request);
    }

    public interface Callback<R> {
        Class<R> getEntityType();

        void onSucceed(R response);

        void onFailure(VolleyError error);
    }
}
