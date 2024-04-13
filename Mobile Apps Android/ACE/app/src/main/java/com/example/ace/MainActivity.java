package com.example.ace;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        navController = Navigation.findNavController(this, R.id.fragmentContainerView);
//
//        bottomNavigationView = findViewById(R.id.bottom_navigation);
//
//        // setup navigation
//        NavigationUI.setupWithNavController(bottomNavigationView, navController);
    }


}