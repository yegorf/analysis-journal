package com.example.analysis_journal.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.analysis_journal.R;
import com.example.analysis_journal.entity.Result;

import java.util.List;

public class JournalAdapter extends RecyclerView.Adapter<JournalAdapter.JournalHolder> {

    private List<Result> analyses;
    private LayoutInflater inflater;
    private Context context;

    public JournalAdapter(List<Result> analyses, Context context) {
        this.analyses = analyses;
        this.inflater = LayoutInflater.from(context);
        this.context = context;
    }

    @NonNull
    @Override
    public JournalHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.holder_journal, parent, false);
        context = view.getContext();
        return new JournalHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JournalHolder holder, int position) {
        Result analyse = analyses.get(position);
    }

    @Override
    public int getItemCount() {
        return analyses.size();
    }

    class JournalHolder extends RecyclerView.ViewHolder {

        JournalHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
