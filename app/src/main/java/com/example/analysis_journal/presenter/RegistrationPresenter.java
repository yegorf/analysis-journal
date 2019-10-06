package com.example.analysis_journal.presenter;

import android.app.Activity;

import com.example.analysis_journal.entity.User;
import com.example.analysis_journal.view.RegistrationView;
import com.example.analysis_journal.view.View;

public interface RegistrationPresenter extends Presenter<RegistrationView> {
    void addUser(Activity activity, User user);
}
