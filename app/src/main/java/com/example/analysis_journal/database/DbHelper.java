package com.example.analysis_journal.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.analysis_journal.database.contract.AnalysisContract;
import com.example.analysis_journal.database.contract.ResultContract;
import com.example.analysis_journal.database.contract.UserContract;

import static com.example.analysis_journal.database.Constants.CLOSE_BRACKET;
import static com.example.analysis_journal.database.Constants.COMMA;
import static com.example.analysis_journal.database.Constants.CREATE_TABLE_IF_NOT_EXISTS;
import static com.example.analysis_journal.database.Constants.DROP_TABLE_IF_EXISTS;
import static com.example.analysis_journal.database.Constants.INTEGER_TYPE;
import static com.example.analysis_journal.database.Constants.OPEN_BRACKET;
import static com.example.analysis_journal.database.Constants.PRIMARY_KEY;
import static com.example.analysis_journal.database.Constants.TEXT_TYPE;


public class DbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "journal.db";
    private static final int DATABASE_VERSION = 5;

    private static final String SQL_CREATE_ANALYSIS_TABLE =
            CREATE_TABLE_IF_NOT_EXISTS + ResultContract.ResultEntry.TABLE_NAME +
                    OPEN_BRACKET +
                    ResultContract.ResultEntry._ID + INTEGER_TYPE + PRIMARY_KEY + COMMA +
                    ResultContract.ResultEntry.COLUMN_DATE + TEXT_TYPE + COMMA +
                    ResultContract.ResultEntry.COLUMN_NAME + TEXT_TYPE + COMMA +
                    ResultContract.ResultEntry.COLUMN_RESULT + TEXT_TYPE +
                    CLOSE_BRACKET;

    private static final String SQL_CREATE_USER_TABLE =
            CREATE_TABLE_IF_NOT_EXISTS + UserContract.UserEntry.TABLE_NAME +
                    OPEN_BRACKET +
                    UserContract.UserEntry._ID + INTEGER_TYPE + PRIMARY_KEY + COMMA +
                    UserContract.UserEntry.COLUMN_NAME + TEXT_TYPE + COMMA +
                    UserContract.UserEntry.COLUMN_PASSWORD + TEXT_TYPE + COMMA +
                    UserContract.UserEntry.COLUMN_SEX + TEXT_TYPE + COMMA +
                    UserContract.UserEntry.COLUMN_EMAIL + TEXT_TYPE +
                    CLOSE_BRACKET;

    private static final String SQL_CREATE_DIRECTORY_TABLE =
            CREATE_TABLE_IF_NOT_EXISTS + AnalysisContract.AnalysisEntry.TABLE_NAME +
                    OPEN_BRACKET +
                    AnalysisContract.AnalysisEntry._ID + INTEGER_TYPE + PRIMARY_KEY + COMMA +
                    AnalysisContract.AnalysisEntry.COLUMN_NAME + TEXT_TYPE + COMMA +
                    AnalysisContract.AnalysisEntry.COLUMN_RESULT + TEXT_TYPE + COMMA +
                    AnalysisContract.AnalysisEntry.COLUMN_URL + TEXT_TYPE +
                    CLOSE_BRACKET;

    private static final String SQL_DELETE_RESULT_TABLE = DROP_TABLE_IF_EXISTS + ResultContract.ResultEntry.TABLE_NAME;

    private static final String SQL_DELETE_USER_TABLE = DROP_TABLE_IF_EXISTS + UserContract.UserEntry.TABLE_NAME;

    private static final String SQL_DELETE_DIRECTORY_TABLE = DROP_TABLE_IF_EXISTS + AnalysisContract.AnalysisEntry.TABLE_NAME;

    private Context context;

    DbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_ANALYSIS_TABLE);
        sqLiteDatabase.execSQL(SQL_CREATE_USER_TABLE);
        sqLiteDatabase.execSQL(SQL_CREATE_DIRECTORY_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        recreateAll(sqLiteDatabase);
    }

    private void recreateAll(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_DELETE_RESULT_TABLE);
        sqLiteDatabase.execSQL(SQL_DELETE_USER_TABLE);
        sqLiteDatabase.execSQL(SQL_DELETE_DIRECTORY_TABLE);
        onCreate(sqLiteDatabase);
    }
}
