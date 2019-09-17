package com.example.analysis_journal.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.analysis_journal.R;
import com.example.analysis_journal.navigation.NavigationManager;

public class MainActivity extends AppCompatActivity {

    private NavigationManager navigationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigationManager = new NavigationManager(getSupportFragmentManager());
        navigationManager.openFragment(NavigationManager.SCREEN_JOURNAL);
    }
}
