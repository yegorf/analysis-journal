package com.example.analysis_journal.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.analysis_journal.R;
import com.example.analysis_journal.presenter.LoginPresenter;
import com.example.analysis_journal.presenter.LoginPresenterImpl;
import com.example.analysis_journal.view.LoginView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginFragment extends Fragment implements LoginView {

    @BindView(R.id.et_login_email)
    EditText loginEmail;

    @BindView(R.id.et_login_password)
    EditText loginPassword;

    private LoginPresenter presenter = new LoginPresenterImpl(getContext());

    public static LoginFragment getInstance() {
        return new LoginFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_result, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.btn_sign_in)
    public void onSignInClick() {
        String email = loginEmail.getText().toString();
        String password = loginPassword.getText().toString();

        presenter.login(email, password);
    }
}
