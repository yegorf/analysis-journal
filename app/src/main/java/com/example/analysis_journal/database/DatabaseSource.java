package com.example.analysis_journal.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.analysis_journal.database.contract.AnalysisContract;
import com.example.analysis_journal.database.contract.ResultContract;
import com.example.analysis_journal.entity.Analysis;
import com.example.analysis_journal.entity.Result;

import java.util.ArrayList;
import java.util.List;

public class DatabaseSource {

    private DbHelper helper;
    private Context context;

    public DatabaseSource(Context context) {
        this.context = context;
        helper = new DbHelper(context);
    }

    public long addResult(Result result) {
        SQLiteDatabase database = helper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        long id;

        try {
            contentValues.put(ResultContract.ResultEntry.COLUMN_NAME, result.getName());
            contentValues.put(ResultContract.ResultEntry.COLUMN_RESULT, result.getResult());
            id = database.insert(ResultContract.ResultEntry.TABLE_NAME, null, contentValues);
            database.setTransactionSuccessful();
        } finally {
            database.endTransaction();
        }
        return id;
    }

    public List<Result> getAllResults() {
        SQLiteDatabase database = helper.getReadableDatabase();
        List<Result> result = new ArrayList<>();

        String[] projection = { ResultContract.ResultEntry.COLUMN_NAME,
                ResultContract.ResultEntry.COLUMN_RESULT };

        if (database != null) {
            database.beginTransaction();

            try (Cursor cursor = database.query(ResultContract.ResultEntry.TABLE_NAME, projection,
                    null, null, null, null, null)) {
                Result analysis = new Result();
                while (cursor.moveToNext()) {
                    analysis.setName(cursor.getString(cursor.getColumnIndex(ResultContract.ResultEntry.COLUMN_NAME)));
                    analysis.setResult(cursor.getString(cursor.getColumnIndex(ResultContract.ResultEntry.COLUMN_RESULT)));
                    result.add(analysis);
                }
            } finally {
                database.endTransaction();
            }
        }
        return result;
    }

    public List<Analysis> getAllAnalyses() {
        SQLiteDatabase database = helper.getReadableDatabase();
        List<Analysis> result = new ArrayList<>();

        String[] projection = {AnalysisContract.AnalysisEntry.COLUMN_NAME,
                AnalysisContract.AnalysisEntry.COLUMN_RESULT,
                AnalysisContract.AnalysisEntry.COLUMN_URL};

        if (database != null) {
            database.beginTransaction();

            try (Cursor cursor = database.query(AnalysisContract.AnalysisEntry.TABLE_NAME, projection,
                    null, null, null, null, null)) {
                Analysis analysis = new Analysis();
                while (cursor.moveToNext()) {
                    analysis.setName(cursor.getString(cursor.getColumnIndex(AnalysisContract.AnalysisEntry.COLUMN_NAME)));
                    analysis.setName(cursor.getString(cursor.getColumnIndex(AnalysisContract.AnalysisEntry.COLUMN_RESULT)));
                    analysis.setName(cursor.getString(cursor.getColumnIndex(AnalysisContract.AnalysisEntry.COLUMN_URL)));
                    result.add(analysis);
                }
            } finally {
                database.endTransaction();
            }
        }
        return result;
    }

    public Analysis getAnalysisByName(String name) {
        Analysis analysis = new Analysis();

        return analysis;
    }
}
