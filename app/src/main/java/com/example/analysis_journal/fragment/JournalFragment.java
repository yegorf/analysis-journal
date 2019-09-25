package com.example.analysis_journal.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.analysis_journal.R;
import com.example.analysis_journal.navigation.NavigationManager;

import androidx.annotation.BinderThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class JournalFragment extends Fragment {

    @BindView(R.id.btn_add_analyse)
    public Button addAnalyseBtn;

    @BindView(R.id.rv_journal)
    public RecyclerView journalRecycler;

    @OnClick(R.id.btn_add_analyse)
    void redirectAddAnalyse() {
        NavigationManager manager = new NavigationManager(getFragmentManager());
        manager.openFragment(NavigationManager.SCREEN_ADD_RESULT);
    }

    public static JournalFragment newInstance() {
        return new JournalFragment();
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

    }
}
