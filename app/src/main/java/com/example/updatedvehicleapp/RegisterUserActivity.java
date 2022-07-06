package com.example.updatedvehicleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import com.example.updatedvehicleapp.database.DataBaseHelper;
import com.example.updatedvehicleapp.model.UserModel;

public class RegisterUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);
        DataBaseHelper db = new DataBaseHelper(this);

        EditText userIdText= findViewById(R.id.userId);
        EditText usernameText= findViewById(R.id.username);
        EditText passwordText = findViewById(R.id.password);
        EditText emailText = findViewById(R.id.email);
        EditText roleText = findViewById(R.id.role);
        EditText phoneText = findViewById(R.id.phone);
        EditText nicText = findViewById(R.id.nic);
        EditText imageText = findViewById(R.id.image);

        Context context = this;

        Button btnLogin = findViewById(R.id.register);
        btnLogin.setOnClickListener(v -> {

            String userId = userIdText.getText().toString();
            String username = usernameText.getText().toString();
            String password = passwordText.getText().toString();
            String email = emailText.getText().toString();
            String role = roleText.getText().toString();
            Integer phone = Integer.valueOf(phoneText.getText().toString());
            String nic = nicText.getText().toString();
            String image = imageText.getText().toString();

            if(userIdText.getText().toString().trim().length()==0){
                userIdText.setError("UserId is not entered");
                userIdText.requestFocus();
            }
            if(usernameText.getText().toString().trim().length()==0){
                usernameText.setError("UserName is not entered");
                usernameText.requestFocus();
            }
            if(passwordText.getText().toString().trim().length()==0){
                passwordText.setError("Password is not entered");
                passwordText.requestFocus();
            }
            if(emailText.getText().toString().trim().length()==0){
                emailText.setError("Email is not entered");
                emailText.requestFocus();
            }
            if(roleText.getText().toString().trim().length()==0){
                roleText.setError("Role is not entered");
                roleText.requestFocus();
            }
            if(phoneText.getText().toString().trim().length()==0){
                phoneText.setError("Phone is not entered");
                phoneText.requestFocus();
            }
            if(nicText.getText().toString().trim().length()==0){
                nicText.setError("Nic is not entered");
                nicText.requestFocus();
            }
            if(imageText.getText().toString().trim().length()==0){
                imageText.setError("Nic is not entered");
                imageText.requestFocus();
            }
            else{
                Intent next =new Intent(getApplicationContext(), MainActivity.class);
                startActivity(next);
            }
            UserModel userM = new UserModel(userId, username, password, email, role, phone, nic, image);
            db.addUser(userM);
        });
    }
}