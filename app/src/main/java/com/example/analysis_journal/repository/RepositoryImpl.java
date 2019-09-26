package com.example.analysis_journal.repository;

import android.content.Context;

import com.example.analysis_journal.database.DatabaseSource;
import com.example.analysis_journal.entity.Analysis;
import com.example.analysis_journal.entity.User;

import java.util.List;

public class RepositoryImpl implements Repository{

    private Context context;
    private DatabaseSource databaseSource;

    public RepositoryImpl(Context context) {
        this.context = context;
        this.databaseSource = new DatabaseSource(context);
    }

    @Override
    public long addResult(Analysis analysis) {
        return databaseSource.addAnalysis(analysis);
    }

    @Override
    public List<Analysis> getAllAnalyses() {
        return databaseSource.getAllAnalysis();
    }

    @Override
    public long addUser(User user) {
        return 0;
    }
}
