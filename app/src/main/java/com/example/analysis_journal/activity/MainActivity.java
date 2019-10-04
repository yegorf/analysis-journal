package com.example.analysis_journal.activity;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.analysis_journal.R;
import com.example.analysis_journal.account.CurrentUser;
import com.example.analysis_journal.database.DatabaseSource;
import com.example.analysis_journal.database.util.DirectoryFiller;
import com.example.analysis_journal.entity.Analysis;
import com.example.analysis_journal.navigation.NavigationManager;
import com.example.analysis_journal.presenter.LoginPresenter;
import com.example.analysis_journal.presenter.MainActivityPresenter;
import com.example.analysis_journal.presenter.MainActivityPresenterImpl;
import com.example.analysis_journal.view.MainActivityView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainActivityView {

    private NavigationManager navigationManager;
    private MainActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainActivityPresenterImpl(this);
        presenter.onCreate(this);

        SharedPreferences preferences = getPreferences(Context.MODE_PRIVATE);
        int id = preferences.getInt(CurrentUser.USER_PREFERENCES_ID, -1);
        if (id != -1) {
            presenter.setCurrentUser(id);
        }

        navigationManager = new NavigationManager(getSupportFragmentManager());
        navigationManager.openFragment(NavigationManager.SCREEN_JOURNAL);

        DirectoryFiller.fillDirectory(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_manu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.item_sign_in:
                navigationManager.openFragment(NavigationManager.SCREEN_SIGN_IN);
                return true;
            case R.id.item_sign_up:
                navigationManager.openFragment(NavigationManager.SCREEN_SIGN_UP);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        navigationManager.navigateBack(this);
    }
}
