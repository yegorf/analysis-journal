package com.example.analysis_journal.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.analysis_journal.R;
import com.example.analysis_journal.constants.Event;
import com.example.analysis_journal.utils.CurrentUser;
import com.example.analysis_journal.navigation.NavigationManager;
import com.example.analysis_journal.utils.RxBus;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NavigationFragment extends Fragment {

    @BindView(R.id.ib_journal)
    public ImageButton journalBtn;

    @BindView(R.id.ib_info)
    public ImageButton infoBtn;

    @BindView(R.id.ib_directory)
    public ImageButton statisticBtn;

    @BindView(R.id.tv_username)
    public TextView usernameTv;

    @OnClick(R.id.ib_directory)
    void redirectDirectory() {
        NavigationManager manager = new NavigationManager(getFragmentManager());
        manager.openFragment(NavigationManager.SCREEN_DIRECTORY);
    }

    @OnClick(R.id.ib_journal)
    void redirectJournal() {
        NavigationManager manager = new NavigationManager(getFragmentManager());
        manager.openFragment(NavigationManager.SCREEN_JOURNAL);
    }

    @OnClick(R.id.ib_info)
    void redirectInfo() {
        NavigationManager manager = new NavigationManager(getFragmentManager());
        manager.openFragment(NavigationManager.SCREEN_INFO);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_navigation, container, false);
        ButterKnife.bind(this, view);

        setUserLabel();
        RxBus.subscribe(Event.SIGN_UP, this::setUserLabel);
        return view;
    }

    private void setUserLabel() {
        //TODO remove delay
        new Handler().postDelayed(() -> {
            if (CurrentUser.getUser() == null) {
                usernameTv.setText("Log in");
            } else {
                usernameTv.setText(CurrentUser.getUser().getName());
            }
        }, 100);
    }
}
