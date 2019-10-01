package com.example.analysis_journal.presenter;

import android.content.Context;

import com.example.analysis_journal.database.util.DirectoryFiller;
import com.example.analysis_journal.entity.Result;
import com.example.analysis_journal.repository.Repository;
import com.example.analysis_journal.repository.RepositoryImpl;
import com.example.analysis_journal.view.JournalView;

import java.util.List;

public class JournalPresenterImpl extends BasePresenter<JournalView> implements JournalPresenter {

    private Context context;
    private Repository repository;

    public JournalPresenterImpl(Context context) {
        this.context = context;
        this.repository = new RepositoryImpl(context);
    }

    @Override
    public void onCreate(JournalView view) {
        super.onCreate(view);

        if (view != null) {
            List<Result> analyses = repository.getAllResults();
            view.showAnalyses(analyses);
        }

        DirectoryFiller.fillDirectory(context);
    }

    @Override
    public void onRelease(boolean complete) {
        super.onRelease(complete);
    }
}
