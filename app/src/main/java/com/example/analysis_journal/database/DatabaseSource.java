package com.example.analysis_journal.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.analysis_journal.database.contract.AnalysisContract;
import com.example.analysis_journal.entity.Analysis;

import java.util.ArrayList;
import java.util.List;

public class DatabaseSource {

    private DbHelper helper;
    private Context context;

    public DatabaseSource(Context context) {
        this.context = context;
        helper = new DbHelper(context);
    }

    public long addAnalysis(Analysis analysis) {
        SQLiteDatabase database = helper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        long id;

        try {
            database.beginTransaction();
            contentValues.put(AnalysisContract.AnalysisEntry.COLUMN_NAME, analysis.getName());
            contentValues.put(AnalysisContract.AnalysisEntry.COLUMN_RESULT, analysis.getResult());
            id = database.insert(AnalysisContract.AnalysisEntry.TABLE_NAME, null, contentValues);
            database.setTransactionSuccessful();
        } finally {
            database.endTransaction();
        }
        return id;
    }

    public List<Analysis> getAllAnalysis() {
        SQLiteDatabase database = helper.getReadableDatabase();
        List<Analysis> result = new ArrayList<>();

        String[] projection = { AnalysisContract.AnalysisEntry.COLUMN_NAME,
                AnalysisContract.AnalysisEntry.COLUMN_RESULT };

        if (database != null) {
            database.beginTransaction();

            try (Cursor cursor = database.query(AnalysisContract.AnalysisEntry.TABLE_NAME, projection,
                    null, null, null, null, null)) {
                while (cursor.moveToNext()) {
                    Analysis analysis = new Analysis();
                    analysis.setName(cursor.getString(cursor.getColumnIndex(AnalysisContract.AnalysisEntry.COLUMN_NAME)));
                    analysis.setResult(cursor.getString(cursor.getColumnIndex(AnalysisContract.AnalysisEntry.COLUMN_RESULT)));
                    result.add(analysis);
                }
            } finally {
                database.endTransaction();
            }
        }
        return result;
    }
}
