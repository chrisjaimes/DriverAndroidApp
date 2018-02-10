package com.bignerdranch.android.driverapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.os.AsyncTask;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.InputStream;
import java.io.OutputStream;

public class MainActivity extends AppCompatActivity {

    private Button login_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login_button = (Button) findViewById(R.id.login_button);

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Login button", "clicked");

                Login login = new Login();
                login.execute("http://10.0.2.2:80/testdriverapp/main.php");
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();

        Log.d("Start", "started");

    }

    @Override
    public void onResume() {
        super.onResume();

        Log.d("Resume", "resumed");
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();

        Log.d("Stop", "stopped");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Log.d("Destroy", "destroy");
    }

    private static class Login extends AsyncTask<String, String, String>{
        @Override
        protected void onPreExecute() {
            Log.d("Login", "logging in...");
        }

        @Override
        protected String doInBackground(String... params) {
            HttpURLConnection con;

            try {
                URL url = new URL(params[0]);
                con = (HttpURLConnection) url.openConnection();
                if(con.getResponseCode() == HttpURLConnection.HTTP_OK) {
                    InputStream is = con.getInputStream();
                    BufferedReader buffer = new BufferedReader(new InputStreamReader(is));

                    Log.d("Login Response", buffer.readLine());
                    buffer.close();
                }
            } catch (Exception e) {
                Log.e("Login", e+"");
            }
            return "Done";
        }
    }
}
