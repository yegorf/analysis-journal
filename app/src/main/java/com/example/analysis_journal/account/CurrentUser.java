package com.example.analysis_journal.account;

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
}
