package com.blueradix.android.monstersapp1_final;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.blueradix.android.monstersapp1_final.monster.show.ShowMonstersFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, ShowMonstersFragment.newInstance())
                    .commitNow();
        }
    }
}