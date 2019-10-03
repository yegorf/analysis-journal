package com.example.analysis_journal.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.analysis_journal.database.contract.AnalysisContract;
import com.example.analysis_journal.database.contract.ResultContract;
import com.example.analysis_journal.database.contract.UserContract;
import com.example.analysis_journal.entity.Analysis;
import com.example.analysis_journal.entity.Result;
import com.example.analysis_journal.entity.User;

import java.util.ArrayList;
import java.util.List;

public class DatabaseSource {

    private DbHelper helper;
    private Context context;

    public DatabaseSource(Context context) {
        this.context = context;
        helper = new DbHelper(context);
    }

    public void fillDirectory(List<Analysis> analyses) {
        try (SQLiteDatabase database = helper.getWritableDatabase()) {
            ContentValues contentValues = new ContentValues();
            for (Analysis analysis : analyses) {
                contentValues.put(AnalysisContract.AnalysisEntry.COLUMN_NAME, analysis.getName());
                contentValues.put(AnalysisContract.AnalysisEntry.COLUMN_RESULT, analysis.getResult());
                contentValues.put(AnalysisContract.AnalysisEntry.COLUMN_URL, analysis.getUrl());
                database.insert(AnalysisContract.AnalysisEntry.TABLE_NAME, null, contentValues);
            }
        }
    }

    public long addResult(Result result) {
        long id;
        try (SQLiteDatabase database = helper.getWritableDatabase()) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(ResultContract.ResultEntry.COLUMN_DATE, result.getDate());
            contentValues.put(ResultContract.ResultEntry.COLUMN_NAME, result.getName());
            contentValues.put(ResultContract.ResultEntry.COLUMN_RESULT, result.getResult());
            id = database.insert(ResultContract.ResultEntry.TABLE_NAME, null, contentValues);
        }
        return id;
    }

    public long addUser(User user) {
        long id;
        try (SQLiteDatabase database = helper.getWritableDatabase()) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(UserContract.UserEntry.COLUMN_NAME, user.getName());
            contentValues.put(UserContract.UserEntry.COLUMN_SEX, user.getSex().getText());
            contentValues.put(UserContract.UserEntry.COLUMN_EMAIL, user.getEmail());
            contentValues.put(UserContract.UserEntry.COLUMN_PASSWORD, user.getPassword());
            id = database.insert(UserContract.UserEntry.TABLE_NAME, null, contentValues);
        }
        return id;
    }

    public List<Result> getAllResults() {
        SQLiteDatabase database = helper.getReadableDatabase();
        List<Result> result = new ArrayList<>();

        String[] projection = { ResultContract.ResultEntry.COLUMN_NAME,
                ResultContract.ResultEntry.COLUMN_RESULT,
                ResultContract.ResultEntry.COLUMN_DATE};

        if (database != null) {
            try (Cursor cursor = database.query(ResultContract.ResultEntry.TABLE_NAME, projection,
                    null, null, null, null, null)) {
                while (cursor.moveToNext()) {
                    Result analysis = new Result();
                    analysis.setName(cursor.getString(cursor.getColumnIndex(ResultContract.ResultEntry.COLUMN_NAME)));
                    analysis.setResult(cursor.getString(cursor.getColumnIndex(ResultContract.ResultEntry.COLUMN_RESULT)));
                    analysis.setDate(cursor.getString(cursor.getColumnIndex(ResultContract.ResultEntry.COLUMN_DATE)));
                    result.add(analysis);
                }
            } finally {
                database.close();
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
                while (cursor.moveToNext()) {
                    Analysis analysis = new Analysis();
                    analysis.setName(cursor.getString(cursor.getColumnIndex(AnalysisContract.AnalysisEntry.COLUMN_NAME)));
                    analysis.setResult(cursor.getString(cursor.getColumnIndex(AnalysisContract.AnalysisEntry.COLUMN_RESULT)));
                    analysis.setUrl(cursor.getString(cursor.getColumnIndex(AnalysisContract.AnalysisEntry.COLUMN_URL)));
                    result.add(analysis);
                }
            } finally {
                database.endTransaction();
                database.close();
            }
        }
        return result;
    }

    public Analysis getAnalysisByName(String name) {
        Analysis analysis = new Analysis();

        return analysis;
    }
}
