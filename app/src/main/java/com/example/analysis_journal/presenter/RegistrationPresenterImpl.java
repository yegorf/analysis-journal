package com.example.analysis_journal.presenter;

import android.content.Context;

import com.example.analysis_journal.constants.Event;
import com.example.analysis_journal.entity.User;
import com.example.analysis_journal.repository.Repository;
import com.example.analysis_journal.repository.RepositoryImpl;
import com.example.analysis_journal.utils.CurrentUser;
import com.example.analysis_journal.utils.RxBus;
import com.example.analysis_journal.view.AddResultView;
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

        if (id != -1) {
            CurrentUser.setUser(repository.getUserById((int) id));
            RxBus.send(Event.SIGN_UP);
        }

        if (view != null) {
            view.addUser(id);
        }
    }
}
