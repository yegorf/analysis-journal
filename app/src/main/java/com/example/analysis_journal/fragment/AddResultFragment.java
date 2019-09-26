package com.example.analysis_journal.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.analysis_journal.R;
import com.example.analysis_journal.entity.Analysis;
import com.example.analysis_journal.presenter.AddResultPresenter;
import com.example.analysis_journal.presenter.AddResultPresenterImpl;
import com.example.analysis_journal.presenter.Presenter;
import com.example.analysis_journal.view.AddResultView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddResultFragment extends Fragment implements AddResultView {

    @BindView(R.id.et_analyse_name)
    public EditText analyseNameEt;

    @BindView(R.id.et_analyse_result)
    public EditText analyseResultEt;

    @BindView(R.id.et_analyse_date)
    public EditText analyseDateEt;

    @BindView(R.id.btn_add_result)
    public Button addResultBtn;

    //TODO inject
    private AddResultPresenterImpl presenter = new AddResultPresenterImpl();

    public static AddResultFragment newInstance() {
        return new AddResultFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_result, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.btn_add_result)
    public void onAddResultClick() {
        String name = analyseNameEt.getText().toString();
        String result = analyseResultEt.getText().toString();
        presenter.addResult(new Analysis(name, result));

    }

    @Override
    public void addResult() {

    }
}
