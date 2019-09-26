package com.example.analysis_journal.presenter;

import android.content.Context;

import com.example.analysis_journal.entity.User;
import com.example.analysis_journal.repository.Repository;
import com.example.analysis_journal.repository.RepositoryImpl;
import com.example.analysis_journal.view.RegistrationView;

public class RegistrationPresenterImpl extends BasePresenter<RegistrationView> implements RegistrationPresenter {

    private Repository repository;

    public RegistrationPresenterImpl(Context context) {
        this.repository = new RepositoryImpl(context);
    }

    @Override
    public void addUser(User user) {
        RegistrationView view = getView();

        long id = repository.addUser(user);
        if (view != null) {
            view.addUser(id);
        }
    }
}
