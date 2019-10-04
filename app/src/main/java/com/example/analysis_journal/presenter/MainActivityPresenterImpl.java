package com.example.analysis_journal.presenter;

import android.content.Context;

import com.example.analysis_journal.account.CurrentUser;
import com.example.analysis_journal.repository.Repository;
import com.example.analysis_journal.repository.RepositoryImpl;
import com.example.analysis_journal.view.MainActivityView;

public class MainActivityPresenterImpl extends BasePresenter<MainActivityView> implements MainActivityPresenter {

    private Context context;
    private Repository repository;

    public MainActivityPresenterImpl(Context context) {
        this.context = context;
        repository = new RepositoryImpl(context);
    }

    @Override
    public void setCurrentUser(int id) {
        CurrentUser.setUser(repository.getUserById(id));
    }
}
