package com.example.analysis_journal.view;

import com.example.analysis_journal.entity.Result;

import java.util.List;

public interface JournalView extends View {
    void showAnalyses(List<Result> analyses);
}
