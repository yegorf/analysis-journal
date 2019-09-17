package com.example.analysis_journal.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.analysis_journal.R;
import com.example.analysis_journal.navigation.NavigationManager;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NavigationFragment extends Fragment {

    @BindView(R.id.ib_journal)
    public ImageButton journalBtn;

    @BindView(R.id.ib_info)
    public ImageButton infoBtn;

    @BindView(R.id.ib_statistic)
    public ImageButton statisticBtn;

    @BindView(R.id.ib_document)
    public ImageButton documentBtn;

    NavigationFragment getInstance() {
        return new NavigationFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_navigation, container, false);
        ButterKnife.bind(this, view);
        initViews();
        return view;
    }

    private void initViews() {
        journalBtn.setOnClickListener(e -> {
            NavigationManager manager = new NavigationManager(getFragmentManager());
            manager.openFragment(NavigationManager.SCREEN_JOURNAL);
        });

        infoBtn.setOnClickListener(e -> {
            NavigationManager manager = new NavigationManager(getFragmentManager());
            manager.openFragment(NavigationManager.SCREEN_INFO);
        });
    }
}
