package com.example.analysis_journal.presenter;

import android.content.Context;

import com.example.analysis_journal.entity.Analysis;
import com.example.analysis_journal.repository.Repository;
import com.example.analysis_journal.repository.RepositoryImpl;
import com.example.analysis_journal.view.DirectoryView;

import java.util.List;

public class DirectoryPresenterImpl extends BasePresenter<DirectoryView> implements DirectoryPresenter {

    private Context context;
    private Repository repository;

    public DirectoryPresenterImpl(Context context) {
        this.context = context;
        this.repository = new RepositoryImpl(context);
    }

    @Override
    public void onCreate(DirectoryView view) {
        super.onCreate(view);

        if (view != null) {
            List<Analysis> analyses = repository.getAllAnalyses();
            view.setDirectory(analyses);
        }
    }
}
