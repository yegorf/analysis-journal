package com.example.analysis_journal.presenter;

import android.content.Context;

import com.example.analysis_journal.entity.Analysis;
import com.example.analysis_journal.repository.Repository;
import com.example.analysis_journal.repository.RepositoryImpl;
import com.example.analysis_journal.view.AddResultView;

public class AddResultPresenterImpl extends BasePresenter<AddResultView>
        implements AddResultPresenter {

    //TODO inject
    private Context context;
    private Repository repository;

    public AddResultPresenterImpl(Context context) {
        this.context = context;
        this.repository = new RepositoryImpl(context);
    }

    @Override
    public void onCreate(AddResultView view) {

    }

    @Override
    public void onRelease(boolean complete) {

    }

    @Override
    public void addResult(Analysis analysis) {
        AddResultView view = getView();
        if (view != null) {
            long id = repository.addResult(analysis);
            view.addResult(id);
        }
    }
}
