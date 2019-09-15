package com.helloworld2019.foodsamaritan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RSVP extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rsvp);
    }

    public void rsvpOnClick(View view) {
        TextView numAttending = (TextView)findViewById(R.id.numAttending);
        int numAttendingInt = Integer.parseInt(numAttending.getText().toString());

        Toast.makeText(getApplicationContext(),"Success! " + (numAttendingInt + 1) + " signed up.", Toast.LENGTH_SHORT).show();
    }

    public void addOnClick(View view) {
        TextView numAttending = (TextView)findViewById(R.id.numAttending);
        int numAttendingInt = Integer.parseInt(numAttending.getText().toString());

        TextView remainingCount = (TextView)findViewById(R.id.RemainingCount);
        int remainingCountInt = Integer.parseInt(remainingCount.getText().toString());

        if(numAttendingInt + 1 <= remainingCountInt && numAttendingInt + 1 <= 8) {
            numAttending.setText("" + (numAttendingInt + 1));
        }
        else {
            Toast.makeText(getApplicationContext(),"Maximum guests", Toast.LENGTH_SHORT).show();
        }
    }

    public void subtractOnClick(View view) {
        TextView numAttending = (TextView)findViewById(R.id.numAttending);
        int numAttendingInt = Integer.parseInt(numAttending.getText().toString());

        TextView remainingCount = (TextView)findViewById(R.id.RemainingCount);
        int remainingCountInt = Integer.parseInt(remainingCount.getText().toString());

        if(numAttendingInt - 1 >= 0) {
            numAttending.setText("" + (numAttendingInt - 1));
        }
        else {
            Toast.makeText(getApplicationContext(),"Guests can't be less than 0", Toast.LENGTH_SHORT).show();
        }
    }
}
