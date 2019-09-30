package com.example.analysis_journal.view;

import com.example.analysis_journal.entity.Analysis;

import java.util.List;

public interface DirectoryView extends View {
    void setDirectory(List<Analysis> analyses);
}
