package com.example.updatedvehicleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.updatedvehicleapp.database.DataBaseHelper;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedpreferences;
    SharedPreferences.Editor editor;
    public static final String MyPREFERENCES = "MyPrefs";
    Button signupbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        editor = sharedpreferences.edit();

        final EditText emailtext = findViewById(R.id.editTextTextEmailAddress);
        final EditText passwordtxt = findViewById(R.id.editTextTextPassword);

        Context context = this;

        Button btnLogin = findViewById(R.id.login);
        btnLogin.setOnClickListener(v -> {

            String email = emailtext.getText().toString();
            String password = passwordtxt.getText().toString();

            try{
                if(email.length() > 0 && password.length() >0)

                    Log.e("email", email);
                    Log.e("password", password);
                {
                    DataBaseHelper dbUser = new DataBaseHelper(MainActivity.this);
                    dbUser.open();

                    if(dbUser.Login(email, password))
                    {
                        Toast.makeText(MainActivity.this,"Successfully Logged In", Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(MainActivity.this,"Invalid Username/Password", Toast.LENGTH_LONG).show();
                    }
                    dbUser.close();
                }

            }catch(Exception e)
            {
                Toast.makeText(MainActivity.this,e.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

        signupbtn = findViewById(R.id.signup);
        signupbtn.setOnClickListener(v -> {

            Intent next = new Intent( MainActivity.this, RegisterActivity.class);
            startActivity(next);
        });
    }
}