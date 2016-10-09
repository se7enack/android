package com.dorkcloud.higherorlower;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import android.widget.EditText;
import java.util.Random;

public class MainActivity extends ActionBarActivity {
    int randomNumber;

    public void checkGuess(View view) {
        EditText theField = (EditText) findViewById(R.id.theField);
        if (theField.length() != 0) {
            EditText guessNumber = (EditText) findViewById(R.id.theField);
            String guessNumberString = guessNumber.getText().toString();
            int guessNumberInt = Integer.parseInt(guessNumberString);
            System.out.println(randomNumber);

            if (guessNumberInt > randomNumber) {
                Toast.makeText(getApplicationContext(), "Too high", Toast.LENGTH_LONG).show();
            } else if (guessNumberInt < randomNumber) {
                Toast.makeText(getApplicationContext(), "Too low", Toast.LENGTH_LONG).show();
              } else {
                Toast.makeText(getApplicationContext(), "You got it. Great Work!", Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(), "New number now randomly generated. Try again?", Toast.LENGTH_LONG).show();
                Random randomGenerator = new Random();
                randomNumber = randomGenerator.nextInt(10)+1;
            }

        } else {
            Toast.makeText(getApplicationContext(), "Please enter a number between 1-10", Toast.LENGTH_LONG).show();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Random randomGenerator = new Random();
        randomNumber = randomGenerator.nextInt(10)+1;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
