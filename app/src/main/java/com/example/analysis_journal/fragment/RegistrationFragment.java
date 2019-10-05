package com.example.analysis_journal.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.analysis_journal.R;
import com.example.analysis_journal.navigation.NavigationManager;
import com.example.analysis_journal.utils.CurrentUser;
import com.example.analysis_journal.entity.Sex;
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
    Button signUpBtn;

    @BindView(R.id.rb_male)
    RadioButton maleRb;

    @BindView(R.id.rb_female)
    RadioButton femaleRb;

    private RegistrationPresenter presenter;

    public static RegistrationFragment getInstance() {
        return new RegistrationFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_registration, container, false);
        ButterKnife.bind(this, view);
        presenter = new RegistrationPresenterImpl(getContext());
        presenter.onCreate(this);
        return view;
    }

    @OnClick(R.id.btn_sign_up)
    void onSignUpClicked() {
        String name = userName.getText().toString();
        String password = userPassword.getText().toString();
        String email = userEmail.getText().toString();

        Sex sex;
        if (maleRb.isSelected()) {
            sex = Sex.M;
        } else {
            sex = Sex.W;
        }

        presenter.addUser(new User(name, password, email, sex));
    }

    @Override
    public void addUser(long id) {
        if (id != -1) {
            Toast.makeText(getContext(), "Done", Toast.LENGTH_SHORT).show();
            SharedPreferences preferences = getActivity().getPreferences(Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt(CurrentUser.USER_PREFERENCES_ID, (int) id);
            editor.apply();

            NavigationManager manager = new NavigationManager(getFragmentManager());
            manager.openFragment(NavigationManager.SCREEN_JOURNAL);
        } else {
            Toast.makeText(getContext(), "Fail", Toast.LENGTH_SHORT).show();
        }
    }
}
