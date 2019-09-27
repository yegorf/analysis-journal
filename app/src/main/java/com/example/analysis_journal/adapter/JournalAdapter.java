package com.example.analysis_journal.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.analysis_journal.R;
import com.example.analysis_journal.entity.Analysis;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class JournalAdapter extends RecyclerView.Adapter<JournalAdapter.JournalHolder> {

    private List<Analysis> analyses;
    private LayoutInflater inflater;
    private Context context;

    public JournalAdapter(Context context) {
        this.analyses = analyses;
        this.inflater = LayoutInflater.from(context);
        this.context = context;
    }

    public void setAnalyses(List<Analysis> analyses) {
        this.analyses = analyses;
        notifyDataSetChanged();
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
        holder.setData(analyse);
    }

    @Override
    public int getItemCount() {
        return analyses.size();
    }

    class JournalHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_holder_name)
        TextView holderName;

        @BindView(R.id.tv_holder_result)
        TextView holderResult;

        JournalHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void setData(Analysis analysis) {
            holderName.setText(analysis.getName());
            holderResult.setText(analysis.getResult());
        }
    }
}
