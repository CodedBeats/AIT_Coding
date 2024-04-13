package com.example.ace;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.example.ace.affirmation.FavouritesFragment;
import com.example.ace.affirmation.ShowAffirmationFragment;
import com.example.ace.databinding.ActivityMainBinding;
import com.example.ace.user.UserFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

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