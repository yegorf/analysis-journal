package com.example.analysis_journal.utils;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import com.example.analysis_journal.entity.User;

public class CurrentUser {
    public static String USER_PREFERENCES = "USER_PREFERENCES";
    public static String USER_PREFERENCES_ID = "USER_PREFERENCES_ID";
    private static User user;

    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        CurrentUser.user = user;
    }

    public static void saveUserId(Activity activity, int id) {
        SharedPreferences preferences = activity.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(CurrentUser.USER_PREFERENCES_ID, CurrentUser.getUser().getId());
        editor.apply();
    }
}
