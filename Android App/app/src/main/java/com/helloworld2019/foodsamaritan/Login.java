package com.helloworld2019.foodsamaritan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText username = (EditText) findViewById(R.id.username);
        final EditText password = (EditText) findViewById(R.id.password);
        Button loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (username.getText().toString().equals("smakkad@purdue.edu") && password.getText().toString().equals("BoilerUp!")) {
                    //startActivity(new Intent(Login.this, ReplaceThis.class));
                }
            }
        });
    }

    public void signUpOnClick(View view) {
        startActivity(new Intent(Login.this, SignUp.class));
    }
}
