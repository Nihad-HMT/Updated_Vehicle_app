package com.example.updatedvehicleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.updatedvehicleapp.database.DataBaseHelper;
import com.example.updatedvehicleapp.model.VehicleModel;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        DataBaseHelper db = new DataBaseHelper(this);


        EditText vehicleIdText = findViewById(R.id.vehicleId);
        EditText plateNumberText = findViewById(R.id.plateNumber);
        EditText ownerText = findViewById(R.id.owner);
        EditText emailText = findViewById(R.id.email);
        EditText typeText = findViewById(R.id.type);
        EditText phoneText = findViewById(R.id.role);
        EditText colourText = findViewById(R.id.color);
        EditText timeInText = findViewById(R.id.timeIn);
        EditText timeOutText = findViewById(R.id.timeOut);

        Context context = this;

        Button btnLogin = findViewById(R.id.registerv);
        btnLogin.setOnClickListener(v -> {

            String vehicleId = vehicleIdText.getText().toString();
            String plateNumber = plateNumberText.getText().toString();
            String owner = ownerText.getText().toString();
            String email = emailText.getText().toString();
            String type = typeText.getText().toString();
            String phone = phoneText.getText().toString();
            String colour = colourText.getText().toString();
            String timeIn = timeInText.getText().toString();
            String timeOut = timeOutText.getText().toString();

            //db.addVehicle(vehicleId, plateNumber, owner, email, type, phone, color, timeIn, timeOut);
            VehicleModel vehicleM = new VehicleModel(vehicleId, plateNumber, owner, email, type, phone, colour, timeIn, timeOut);
            db.addVehicle(vehicleM);

            Intent back = new Intent(RegisterActivity.this, MainActivity.class);
            startActivity(back);
        });

        ImageView BackButton = findViewById(R.id.imageView7);
        BackButton.setOnClickListener(v -> {
            Intent backButton = new Intent(RegisterActivity.this, HomePageActivity.class);
            startActivity(backButton);
        });
    }
}