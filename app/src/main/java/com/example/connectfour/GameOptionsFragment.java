package com.example.connectfour;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.appcompat.app.AppCompatActivity;

public class GameOptionsFragment extends AppCompatActivity {

    private RadioGroup radioGroupDifficulty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Load the layout for the game options screen
        setContentView(R.layout.fragment_game_options);

        // Get a reference to the RadioGroup that allows difficulty selection
        radioGroupDifficulty = findViewById(R.id.radioGroupDifficulty);

        // Add a listener to handle user interactions with the RadioGroup
        radioGroupDifficulty.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // Get the selected RadioButton based on the chosen option
                RadioButton selectedRadioButton = findViewById(checkedId);
                String gameMode = selectedRadioButton.getText().toString(); // Retrieve the selected difficulty

                // Prepare an intent to send the selected game mode back to MainActivity
                Intent resultIntent = new Intent();
                resultIntent.putExtra("GAME_MODE", gameMode);

                // Send the result back and close the GameOptions activity
                setResult(RESULT_OK, resultIntent);
                finish(); // Return to MainActivity
            }
        });
    }
}
