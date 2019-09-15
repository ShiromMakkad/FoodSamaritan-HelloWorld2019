package com.mapbox.storelocator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.mapbox.storelocator.activity.MapActivity;

public class SignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }

    public void signUpOnClick(View view) {
        EditText firstName = (EditText)findViewById(R.id.FirstName);
        String firstNameString = firstName.getText().toString();

        EditText lastName = (EditText)findViewById(R.id.LastName);
        String lastNameString = firstName.getText().toString();

        EditText username = (EditText)findViewById(R.id.username);
        String usernameString = firstName.getText().toString();

        EditText password = (EditText)findViewById(R.id.password);
        String passwordString = firstName.getText().toString();

        Toast.makeText(getApplicationContext(),"Success!", Toast.LENGTH_SHORT).show();

        startActivity(new Intent(SignUp.this, MapActivity.class));
    }
}
