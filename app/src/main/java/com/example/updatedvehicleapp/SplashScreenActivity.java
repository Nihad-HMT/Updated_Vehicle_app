package com.example.updatedvehicleapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import com.example.updatedvehicleapp.database.ApiRequest;
import com.example.updatedvehicleapp.database.DataBaseHelper;

public class SplashScreenActivity extends AppCompatActivity {
    private DataBaseHelper db;
    private static int SPLASH_TIME_OUT= 10000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        db = new DataBaseHelper(this);
        ApiRequest apiRequest = new ApiRequest();
        apiRequest.getUser(this);
        apiRequest.getVehicle(this);



        new Handler().postDelayed (() -> {

            Intent loginIntent = new Intent( SplashScreenActivity.this,
                    MainActivity.class );
            startActivity(loginIntent);
            finish();

        }, SPLASH_TIME_OUT );
    }


}