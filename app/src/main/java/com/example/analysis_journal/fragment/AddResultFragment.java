package com.example.analysis_journal.fragment;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.analysis_journal.R;
import com.example.analysis_journal.entity.Result;
import com.example.analysis_journal.presenter.AddResultPresenter;
import com.example.analysis_journal.presenter.AddResultPresenterImpl;
import com.example.analysis_journal.trash.AddEvent;
import com.example.analysis_journal.utils.RxBus;
import com.example.analysis_journal.view.AddResultView;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.functions.Action1;

public class AddResultFragment extends Fragment implements AddResultView {

    @BindView(R.id.et_analyse_name)
    public EditText analyseNameEt;

    @BindView(R.id.et_analyse_result)
    public EditText analyseResultEt;

    @BindView(R.id.et_analyse_date)
    public EditText analyseDateEt;

    @BindView(R.id.btn_add_result)
    public Button addResultBtn;

    private AddResultPresenter presenter;// = new AddResultPresenterImpl(getContext());

    public static AddResultFragment getInstance() {
        return new AddResultFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_result, container, false);
        ButterKnife.bind(this, view);
        presenter = new AddResultPresenterImpl(getContext());
        presenter.onCreate(this);

        return view;
    }

    @OnClick(R.id.btn_add_result)
    public void onAddResultClick() {
        String name = analyseNameEt.getText().toString();
        String result = analyseResultEt.getText().toString();
        String date = analyseDateEt.getText().toString();
        presenter.addResult(new Result(name, result, date));
    }

    private DatePickerDialog dialog;
    @OnClick(R.id.et_analyse_date)
    public void onChooseDateClick() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        dialog = new DatePickerDialog(getContext(), (datePicker, i, i1, i2) -> analyseDateEt.setText(i2 + "." + i1 + "." + i), year, month, day);
        dialog.show();
    }

    @Override
    public void addResult(long id) {
        if (id != -1) {
            Toast.makeText(getContext(), "Done", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getContext(), "Fail", Toast.LENGTH_SHORT).show();
        }
    }
}
