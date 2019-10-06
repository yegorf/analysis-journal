package com.example.analysis_journal.presenter;

import android.app.Activity;

import com.example.analysis_journal.view.LoginView;

public interface LoginPresenter extends Presenter<LoginView>  {
    boolean login(Activity activity, String email, String password);
}
