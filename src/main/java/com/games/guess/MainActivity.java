package com.games.guess;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int number = new Random().nextInt(20)+1;
    int increment = number;
    int idx;
    EditText guessedNum;
    String [] cheerLins = {"Yess", "Bravo", "You did it", "Well done"};
    String [] biggerNumLines = {"mmm, bigger" , "Try lower number", "High! try anther one", "oohh , big one"};
    String [] lowerNumLines = {"mmm, small" , "Try high number", "Small! try anther one", "Noo , small one"};

    public void  checkGuessedNumber (View view) {


        guessedNum = (EditText) findViewById(R.id.guessedNumber);
        idx = new Random().nextInt(3);

        try {

            if (Integer.parseInt(guessedNum.getText().toString()) == number) {
                Toast.makeText(MainActivity.this, cheerLins[idx], Toast.LENGTH_LONG).show();
                increment += 10;
                increment %= 1000;
                number = new Random().nextInt(increment);
            } else if (Integer.parseInt(guessedNum.getText().toString()) > number) {
                Toast.makeText(MainActivity.this, biggerNumLines[idx], Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(MainActivity.this, lowerNumLines[idx], Toast.LENGTH_LONG).show();
            }
        }
        catch (NumberFormatException ex) {
            Toast.makeText(MainActivity.this, ex.toString(), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}