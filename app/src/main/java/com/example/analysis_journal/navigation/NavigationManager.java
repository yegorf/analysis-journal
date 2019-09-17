package com.example.analysis_journal.navigation;

import android.app.Activity;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.analysis_journal.R;
import com.example.analysis_journal.fragment.JournalFragment;

public class NavigationManager {

    public static final String SCREEN_JOURNAL = "SCREEN_JOURNAL";
    public static final String SCREEN_INFO = "SCREEN_INFO";
    private FragmentManager fragmentManager;

    public NavigationManager(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }

    public void openFragment(String screenName) {
        Fragment fragment = getFragmentForScreen(screenName);
        if (fragment != null) {
            open(fragment, screenName);
        }
    }

    private void open(Fragment fragment, String screenName) {
        if (fragmentManager != null) {
            fragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .addToBackStack(screenName)
                    .commit();
        }
    }

    private Fragment getFragmentForScreen(String screenName) {
        switch (screenName) {
            case SCREEN_JOURNAL:
                return JournalFragment.newInstance();
            case SCREEN_INFO:
            default:
                return null;
        }
    }

    public void navigateBack(Activity activity) {
        if (isBackStackIsEmpty()) {
            activity.finish();
        } else {
            fragmentManager.popBackStackImmediate();
        }
    }

    private boolean isBackStackIsEmpty() {
        return fragmentManager.getBackStackEntryCount() < 1;
    }

}
