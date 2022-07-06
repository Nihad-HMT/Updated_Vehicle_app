package com.example.updatedvehicleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class HomePageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        ImageView RegisterVehicle = findViewById(R.id.imageView3);
        RegisterVehicle.setOnClickListener(v -> {
            Intent registerVehicle = new Intent(HomePageActivity.this, RegisterActivity.class);
            startActivity(registerVehicle);
        });

        ImageView EditProfile = findViewById(R.id.imageView2);
        EditProfile.setOnClickListener(v -> {
            Intent editProfile = new Intent(HomePageActivity.this, EditProfileActivity.class);
            startActivity(editProfile);
        });

        ImageView btnSignOut = findViewById(R.id.imageView6);
        btnSignOut.setOnClickListener(v -> {
            Intent intent = new Intent(HomePageActivity.this, MainActivity.class);
            startActivity(intent);
        });
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(HomePageActivity.this, MainActivity.class);
        startActivity(intent);
        finishAffinity();
        finish();
    }
}