package com.example.analysis_journal.presenter;

import android.content.Context;

import com.example.analysis_journal.repository.Repository;
import com.example.analysis_journal.repository.RepositoryImpl;
import com.example.analysis_journal.view.LoginView;

public class LoginPresenterImpl extends BasePresenter<LoginView> implements LoginPresenter {
    private Repository repository;

    public LoginPresenterImpl(Context context) {
        this.repository = new RepositoryImpl(context);
    }

    @Override
    public void login(String email, String password) {

    }
}
