package com.example.analysis_journal.database.contract;

import android.provider.BaseColumns;

public class UserContract {

    public UserContract() {

    }

    public static abstract class UserEntry implements BaseColumns {
        public final static String TABLE_NAME = "user";
        public final static String COLUMN_NAME = "name";
        public final static String COLUMN_EMAIL = "email";
        public final static String COLUMN_PASSWORD = "password";
    }
}
