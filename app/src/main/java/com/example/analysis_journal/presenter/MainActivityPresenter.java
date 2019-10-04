package com.example.analysis_journal.presenter;

import com.example.analysis_journal.view.MainActivityView;

public interface MainActivityPresenter extends Presenter<MainActivityView> {
    void setCurrentUser(int id);
}
