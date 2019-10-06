package com.example.analysis_journal.repository;

import com.example.analysis_journal.entity.Analysis;
import com.example.analysis_journal.entity.Result;
import com.example.analysis_journal.entity.User;

import java.util.List;

public interface Repository {

    long addResult(Result result, int userId);

    List<Result> getAllResults(int userId);

    long addUser(User user);

    List<Analysis> getAllAnalyses();

    User getUserById(int id);

    User login(String email, String password);
}
