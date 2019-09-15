package com.mapbox.storelocator;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.mapbox.storelocator.activity.MapActivity;

public class RSVP extends AppCompatActivity {

    int remainingCountInt;
    TextView remainingCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rsvp);

        String title = getIntent().getStringExtra("title");

        TextView input = (TextView)findViewById(R.id.input);
        input.setText(title);

        remainingCount = (TextView)findViewById(R.id.RemainingCount);

        SharedPreferences sharedpreferences = getSharedPreferences("Food Samaritan", Context.MODE_PRIVATE);
        remainingCount.setText("" + sharedpreferences.getInt(title, -1));

        remainingCountInt = Integer.parseInt(remainingCount.getText().toString());

        if(remainingCountInt > 0) {
            remainingCount.setText("" + (remainingCountInt - 1));
        }
        else {
            Toast.makeText(getApplicationContext(),"Event is full", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(RSVP.this, MapActivity.class));
        }
    }

    public void rsvpOnClick(View view) {
        TextView numAttending = (TextView)findViewById(R.id.numAttending);
        int numAttendingInt = Integer.parseInt(numAttending.getText().toString());

        SharedPreferences sharedpreferences = getSharedPreferences("Food Samaritan", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();

        TextView input = (TextView)findViewById(R.id.input);
        String inputText = input.getText().toString();

        editor.putInt(inputText, Integer.parseInt(remainingCount.getText().toString()));
        editor.commit();

        Toast.makeText(getApplicationContext(),"Success! " + (numAttendingInt + 1) + " signed up.", Toast.LENGTH_SHORT).show();

        startActivity(new Intent(RSVP.this, MapActivity.class));
    }

    public void addOnClick(View view) {
        TextView numAttending = (TextView)findViewById(R.id.numAttending);
        int numAttendingInt = Integer.parseInt(numAttending.getText().toString());

        if(numAttendingInt + 1 < remainingCountInt && numAttendingInt + 1 <= 8) {
            numAttending.setText("" + (numAttendingInt + 1));

            remainingCount.setText("" + (Integer.parseInt(remainingCount.getText().toString()) - 1));
        }
        else {
            Toast.makeText(getApplicationContext(),"Maximum guests", Toast.LENGTH_SHORT).show();
        }
    }

    public void subtractOnClick(View view) {
        TextView numAttending = (TextView)findViewById(R.id.numAttending);
        int numAttendingInt = Integer.parseInt(numAttending.getText().toString());

        if(numAttendingInt - 1 >= 0) {
            numAttending.setText("" + (numAttendingInt - 1));

            remainingCount.setText("" + (Integer.parseInt(remainingCount.getText().toString()) + 1));
        }
        else {
            Toast.makeText(getApplicationContext(),"Guests can't be less than 0", Toast.LENGTH_SHORT).show();
        }
    }
}
