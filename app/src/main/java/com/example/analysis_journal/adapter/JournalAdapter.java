package com.example.analysis_journal.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.analysis_journal.R;
import com.example.analysis_journal.entity.Analysis;

import java.util.List;

public class JournalAdapter extends RecyclerView.Adapter<JournalAdapter.JournalHolder> {

    private List<Analysis> analyses;
    private LayoutInflater inflater;
    private Context context;

    public JournalAdapter(List<Analysis> analyses, Context context) {
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
        Analysis analyse = analyses.get(position);
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
