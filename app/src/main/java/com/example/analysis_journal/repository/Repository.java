package com.example.analysis_journal.repository;

import com.example.analysis_journal.entity.Result;
import com.example.analysis_journal.entity.User;

import java.util.List;

public interface Repository {

    long addResult(Result result);

    List<Result> getAllAnalyses();

    long addUser(User user);
}
