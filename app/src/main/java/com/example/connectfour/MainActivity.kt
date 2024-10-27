package com.example.connectfour

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Instantiate an instance of BottomNavigationView
        bottomNavigationView = findViewById(R.id.bottom_navigation)

        // Instantiate an instance of NavHostFragment
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.fragment_container) as NavHostFragment?

        // If the NavHostFragment object is not null
        navHostFragment?.let {
            // Instantiate an instance of NavController
            val navController = it.navController

            // Define top-level destinations for AppBarConfiguration
            val topLevelDestinations = setOf(R.id.boardFragment, R.id.gameOptionsFragment)

            // Instantiate an instance of AppBarConfiguration with top-level destinations
            val appBarConfiguration = AppBarConfiguration.Builder(
                R.id.boardFragment,
                R.id.gameOptionsFragment
            ).build()

            // Call static method NavigationUI.setupActionBarWithNavController
            NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration)

            // Call static method NavigationUI.setupWithNavController
            NavigationUI.setupWithNavController(bottomNavigationView, navController)
        }
    }
}
