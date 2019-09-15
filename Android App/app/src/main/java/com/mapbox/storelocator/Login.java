package com.mapbox.storelocator;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mapbox.storelocator.activity.MapActivity;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharedPreferences sharedpreferences = getSharedPreferences("Food Samaritan", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putInt("Cary Quad", 17);
        editor.putInt("Harrison Residence Hall", 42);
        editor.putInt("Krach Leadership Center", 33);
        editor.commit();


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText username = (EditText) findViewById(R.id.username);
        final EditText password = (EditText) findViewById(R.id.password);
        Button loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (username.getText().toString().equals("smakkad@purdue.edu") && password.getText().toString().equals("BoilerUp!")) {
                    startActivity(new Intent(Login.this, MapActivity.class));
                }
                else {
                    Toast.makeText(getApplicationContext(),"Incorrect Login", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void signUpOnClick(View view) {
        startActivity(new Intent(Login.this, SignUp.class));
    }
}
