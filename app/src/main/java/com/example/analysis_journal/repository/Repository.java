package com.example.analysis_journal.repository;

import com.example.analysis_journal.entity.Analysis;
import com.example.analysis_journal.entity.Result;
import com.example.analysis_journal.entity.User;

import java.util.List;

public interface Repository {

    long addResult(Result result);

    List<Result> getAllResults();

    long addUser(User user);

    List<Analysis> getAllAnalyses();
}
