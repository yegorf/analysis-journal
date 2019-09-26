package com.example.analysis_journal.database.contract;

import android.provider.BaseColumns;

public class AnalysisContract {

    public AnalysisContract() {
    }

    public static abstract class AnalysisEntry implements BaseColumns {
        public static final String TABLE_NAME = "analysis_table";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_RESULT = "analysis_table";
    }
}
