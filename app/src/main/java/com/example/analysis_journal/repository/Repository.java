package com.example.analysis_journal.repository;

import com.example.analysis_journal.entity.Analysis;

import java.util.List;

public interface Repository {

    long addResult(Analysis analysis);

    List<Analysis> getAllAnalyses();
}
