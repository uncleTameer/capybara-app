package com.example.myapplication;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class MainActivity extends AppCompatActivity {

    private RelativeLayout mainLayout;
    private EditText inputText;
    private Button btnCalculate;
    private TextView output;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        mainLayout = findViewById(R.id.mainLayout);
        inputText = findViewById(R.id.inputText);
        btnCalculate = findViewById(R.id.btn1);
        output = findViewById(R.id.output);

        // Initialize MediaPlayer and start the music
        mediaPlayer = MediaPlayer.create(this,R.raw.rit900);

        // Set onClick listener for the button
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the year input from the EditText
                String yearStr = inputText.getText().toString();
                if (!yearStr.isEmpty()) {
                    int birthYear = Integer.parseInt(yearStr);
                    int age = 2024 - birthYear;

                    // Check if the input is valid (you can define what 'correct' means)
                    if (birthYear > 1900 && birthYear <= 2024) {
                        // Change background to party capy image
                        mainLayout.setBackgroundResource(R.drawable.capy);
                        mediaPlayer.start();
                        // Display a toast message
                        Toast.makeText(MainActivity.this, "Capy is happy!", Toast.LENGTH_SHORT).show();
                    }

                    // Display the calculated age in the TextView
                    output.setText("Your age will be: " + age);
                } else {
                    // Handle empty input
                    output.setText("Please enter your birth year.");
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Release the MediaPlayer when the activity is destroyed
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
