package com.example.analysis_journal.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.analysis_journal.R;
import com.example.analysis_journal.navigation.NavigationManager;

import butterknife.BindView;
import butterknife.ButterKnife;

public class JournalFragment extends Fragment {

    @BindView(R.id.btn_add_analyse)
    public Button addAnalyseBtn;

    public static JournalFragment newInstance() {
        JournalFragment fragment = new JournalFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_journal, container, false);
        ButterKnife.bind(this, view);
        initViews();
        return view;
    }

    private void initViews() {
        addAnalyseBtn.setOnClickListener(e -> {
            NavigationManager manager = new NavigationManager(getFragmentManager());
            manager.openFragment(NavigationManager.SCREEN_ADD_RESULT);
        });
    }
}
