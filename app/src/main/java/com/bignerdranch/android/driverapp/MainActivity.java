package com.bignerdranch.android.driverapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.os.AsyncTask;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.InputStream;
import java.io.OutputStream;

public class MainActivity extends AppCompatActivity {

    private Button login_button;
    private TextView email_tf, password_tf;
    private String url = "http://10.0.2.2:80/driverapp-php/main.php"; //change later

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login_button = (Button) findViewById(R.id.login_button);
        email_tf = (TextView) findViewById(R.id.login_tf);
        password_tf = (TextView) findViewById(R.id.password_tf);

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Login button", "clicked");

                new LoginActivity().execute("http://10.0.2.2:80/driverapp-php/main.php");
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

    private void login(View v) {
        String email = email_tf.getText().toString();
        String password = password_tf.getText().toString();

        if(email == null || email.isEmpty())
            Toast.makeText(this, "Enter an email!", Toast.LENGTH_LONG).show();
        else if(password == null || password.isEmpty())
            Toast.makeText(this, "Enter a password!", Toast.LENGTH_LONG).show();

        new LoginActivity().execute(url, email, password);
    }
}
