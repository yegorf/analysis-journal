package com.example.analysis_journal.repository;

import android.content.Context;

import com.example.analysis_journal.database.DatabaseSource;
import com.example.analysis_journal.entity.Analysis;
import com.example.analysis_journal.entity.Result;
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
    public long addResult(Result result) {
        return databaseSource.addResult(result);
    }

    @Override
    public List<Result> getAllResults() {
        return databaseSource.getAllResults();
    }

    @Override
    public long addUser(User user) {
        return databaseSource.addUser(user);
    }

    @Override
    public List<Analysis> getAllAnalyses() {
        return databaseSource.getAllAnalyses();
    }
}
