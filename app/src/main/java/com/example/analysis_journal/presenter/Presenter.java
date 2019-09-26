package com.example.analysis_journal.presenter;

import com.example.analysis_journal.view.View;

public interface Presenter<V extends View> {
    void onCreate(V view);
    void onRelease(boolean complete);
}
