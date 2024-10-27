package com.example.connectfour

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // Register the activity result launcher for the options button
    private val optionsLauncher: ActivityResultLauncher<Intent> = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            val data: Intent? = result.data
            if (data != null) {
                // Get the selected game mode from the result
                val gameMode = data.getStringExtra("GAME_MODE")
                // Display the selected game mode in the format "Easy mode", "Medium mode", or "Hard mode"
                Toast.makeText(this, "$gameMode mode", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Set content view to the main activity layout
        setContentView(R.layout.activity_main)

        // Find the Connect Four and Options buttons
        val connectFourButton: Button = findViewById(R.id.connect_four_button)
        val optionsButton: Button = findViewById(R.id.options_button)

        // Click listener for the Connect Four button to start the Board activity
        connectFourButton.setOnClickListener {
            // Create an intent to start the Board activity
            val boardFragmentIntent = Intent(this@MainActivity, BoardFragment::class.java)
            startActivity(boardFragmentIntent) // Launch the game board activity
        }

        // Click listener for the Options button to start the GameOptions activity
        optionsButton.setOnClickListener {
            // Create an intent to start the GameOptions activity
            val optionsIntent = Intent(this@MainActivity, GameOptionsFragment::class.java)
            optionsLauncher.launch(optionsIntent) // Launch the options activity
        }
    }
}
