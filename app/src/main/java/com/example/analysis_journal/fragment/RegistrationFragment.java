package com.example.analysis_journal.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.analysis_journal.R;
import com.example.analysis_journal.entity.User;
import com.example.analysis_journal.presenter.RegistrationPresenter;
import com.example.analysis_journal.presenter.RegistrationPresenterImpl;
import com.example.analysis_journal.view.RegistrationView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegistrationFragment extends Fragment implements RegistrationView {

    @BindView(R.id.et_user_name)
    EditText userName;

    @BindView(R.id.et_user_password)
    EditText userPassword;

    @BindView(R.id.et_user_email)
    EditText userEmail;

    @BindView(R.id.btn_sign_up)
    EditText signUpBtn;

    private RegistrationPresenter presenter = new RegistrationPresenterImpl(getContext());

    public RegistrationFragment getInstance() {
        return new RegistrationFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_registration, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.btn_sign_up)
    public void onSignUpClicked() {
        String name = userName.getText().toString();
        String password = userPassword.getText().toString();
        String email = userEmail.getText().toString();

        presenter.addUser(new User(name, password, email));
    }

    @Override
    public void addUser(long id) {
        if (id != -1) {
            Toast.makeText(getContext(), "Fail", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getContext(), "Done", Toast.LENGTH_SHORT).show();
        }
    }
}
