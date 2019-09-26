package com.example.analysis_journal.presenter;

import com.example.analysis_journal.view.View;

public class BasePresenter<V extends View> implements Presenter<V> {

    private V view;

    @Override
    public void onCreate(V view) {
        this.view = view;
    }

    @Override
    public void onRelease(boolean complete) {
        view = null;
    }

    public V getView() {
        return view;
    }
}
