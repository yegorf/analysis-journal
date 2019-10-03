package com.example.analysis_journal.presenter;

import com.example.analysis_journal.entity.User;
import com.example.analysis_journal.view.RegistrationView;
import com.example.analysis_journal.view.View;

public interface RegistrationPresenter extends Presenter<RegistrationView> {
    void addUser(User user);
}
