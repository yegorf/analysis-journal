package com.example.analysis_journal.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.example.analysis_journal.R;
import com.example.analysis_journal.adapter.DirectoryAdapter;
import com.example.analysis_journal.entity.Analysis;
import com.example.analysis_journal.presenter.DirectoryPresenter;
import com.example.analysis_journal.presenter.DirectoryPresenterImpl;
import com.example.analysis_journal.view.DirectoryView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class DirectoryFragment extends Fragment implements DirectoryView {
    @BindView(R.id.rv_directory)
    RecyclerView recycler;

    @BindView(R.id.search)
    AutoCompleteTextView search;

    private DirectoryPresenter presenter;

    public static DirectoryFragment getInstance() {
        return new DirectoryFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_directory, container, false);
        ButterKnife.bind(this, view);
        presenter = new DirectoryPresenterImpl(getContext());
        presenter.onCreate(this);

        return view;
    }

    @Override
    public void setDirectory(List<Analysis> analyses) {
        DirectoryAdapter adapter = new DirectoryAdapter(analyses, getContext());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recycler.setLayoutManager(layoutManager);
        recycler.setAdapter(adapter);

        int i=0;
        String[] arr = new String[analyses.size()];
        for (Analysis analysis : analyses) {
            arr[i] = analysis.getName();
            i++;
        }

        ArrayAdapter<String> adapterr =
                new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, arr);
        search.setAdapter(adapterr);
    }
}
