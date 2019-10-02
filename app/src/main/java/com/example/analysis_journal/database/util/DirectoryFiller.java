package com.example.analysis_journal.database.util;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import com.example.analysis_journal.database.DatabaseSource;
import com.example.analysis_journal.entity.Analysis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class DirectoryFiller {
    private static final String DIRECTORY_NAME = "directory.csv";
    private static final String SQL_DIRECTORY_NAME = "sql_directory.sql";
    private static final String SEPARATOR = ";";

    public static void fillDirectory(Context context) {
        AssetManager assetManager;
        InputStreamReader stream;
        BufferedReader reader;
        LinkedList<Analysis> analyses = new LinkedList<>();

        try {
            assetManager = context.getAssets();
            stream = new InputStreamReader(assetManager.open(DIRECTORY_NAME));
            reader = new BufferedReader(stream);

            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    String[] values = line.split(SEPARATOR);
                    analyses.add(new Analysis(values[0], values[1], values[2]));
                } catch (ArrayIndexOutOfBoundsException e) {
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            for (Analysis a : analyses) {
                Log.d("jija", a.toString());
            }
            DatabaseSource source = new DatabaseSource(context);
            source.fillDirectory(analyses);
        }
    }

    public static String getAnalisesInsert(Context context) {
        AssetManager assetManager;
        InputStreamReader stream;
        BufferedReader reader;
        LinkedList<Analysis> analyses = new LinkedList<>();
        StringBuilder builder = new StringBuilder();
        try {
            assetManager = context.getAssets();
            stream = new InputStreamReader(assetManager.open(SQL_DIRECTORY_NAME));
            reader = new BufferedReader(stream);

            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
//        } finally {
//            DatabaseSource source = new DatabaseSource(context);
//            source.fillDirectory(analyses);
//        }

        return builder.toString();
    }
}
