package com.example.updatedvehicleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class RegistrationFormActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_form);
        EditText editTextTextEmailAddress = null;
        EditText editTextTextPassword = null;
        EditText editTextTextPassword2 = null;
        Button signup;

        editTextTextEmailAddress = findViewById(R.id.editTextTextEmailAddress);
        editTextTextPassword = findViewById(R.id.editTextTextPassword);
        editTextTextPassword2 = findViewById(R.id.editTextTextPassword2);
        signup = findViewById(R.id.signup);

        EditText finaleditTextTextEmailAddress = editTextTextEmailAddress;
        EditText finaleditTextTextPassword = editTextTextPassword;
        EditText finaleditTextTextPassword2 = editTextTextPassword2;
        signup.setOnClickListener(arg0 -> {
            // TODO Auto-generated method stub
            if(finaleditTextTextEmailAddress.getText().toString().trim().length()==0){
                finaleditTextTextEmailAddress.setError("UserName is not entered");
                finaleditTextTextEmailAddress.requestFocus();
            }
            if(finaleditTextTextPassword.getText().toString().trim().length()==0){
                finaleditTextTextPassword.setError("Password is not entered");
                finaleditTextTextPassword.requestFocus();
            }
            if(finaleditTextTextPassword2.getText().toString().trim().length()==0){
                finaleditTextTextPassword2.setError("Confirm-Password is not entered");
                finaleditTextTextPassword2.requestFocus();
            }
            else{
                Intent it=new Intent(getApplicationContext(), MainActivity.class);
                startActivity(it);
            }
        });
    }
}