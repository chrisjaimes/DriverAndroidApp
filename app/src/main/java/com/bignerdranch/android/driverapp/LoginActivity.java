package com.bignerdranch.android.driverapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class LoginActivity extends AsyncTask<String, String, String> {

    @Override
    protected void onPreExecute() {
        Log.d("Login", "logging in...");
    }

    private HttpURLConnection setConnection(URL url, String email, String password) throws IOException, JSONException {
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        con.setDoInput(true);
        con.setDoOutput(true);
        con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        con.setRequestProperty("Accept", "application/json");
        con.setRequestMethod("POST");

        JSONObject body = new JSONObject();
        body.put("email", email);
        body.put("password", password);

        OutputStream os = con.getOutputStream();
        os.write(body.toString().getBytes("UTF-8"));
        os.close();

        return con;
    }

    @Override
    protected String doInBackground(String... params) {
        HttpURLConnection con;

        String email = params[1];
        String password = params[2];
        try {
            URL url = new URL(params[0]);
            con = setConnection(url, email, password);

            if(con.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStream is = con.getInputStream();
                BufferedReader buffer = new BufferedReader(new InputStreamReader(is));

                Log.d("Login Response", buffer.readLine());
                buffer.close();
            }
        } catch (Exception e) {
            Log.e("Login exception", e+"");
        }
        return "Done";
    }

    @Override
    protected void onPostExecute(String result) {

    }

}
