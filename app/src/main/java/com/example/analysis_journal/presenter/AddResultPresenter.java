package com.example.analysis_journal.presenter;

import com.example.analysis_journal.entity.Analysis;
import com.example.analysis_journal.view.AddResultView;

public interface AddResultPresenter extends Presenter<AddResultView> {
    void addResult(Analysis analysis);
}
