package com.example.jetpackpersistence;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.jetpackpersistence.monster.MonsterFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main, MonsterFragment.newInstance())
                    .commitNow();
        }
    }
}