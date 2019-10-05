package com.example.analysis_journal.presenter;

import com.example.analysis_journal.view.LoginView;

public interface LoginPresenter extends Presenter<LoginView>  {
    boolean login(String email, String password);
}
