package com.example.analysis_journal.repository;

import android.content.Context;

import com.example.analysis_journal.database.DatabaseSource;
import com.example.analysis_journal.entity.Analysis;

public class RepositoryImpl implements Repository{

    private Context context;
    private DatabaseSource databaseSource;

    public RepositoryImpl(Context context, DatabaseSource databaseSource) {
        this.context = context;
        this.databaseSource = databaseSource;
    }

    @Override
    public long addResult(Analysis analysis) {
        return databaseSource.addAnalysis(analysis);
    }
}
