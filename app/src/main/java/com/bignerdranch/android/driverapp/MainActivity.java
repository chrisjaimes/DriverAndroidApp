package com.bignerdranch.android.driverapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

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
}
