package com.example.analysis_journal.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.analysis_journal.R;
import com.example.analysis_journal.entity.Result;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

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
        Result result = analyses.get(position);
        holder.setText(result);
    }

    @Override
    public int getItemCount() {
        return analyses.size();
    }

    class JournalHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_holder_name)
        TextView nameTv;

        @BindView(R.id.tv_holder_result)
        TextView resultTv;

        JournalHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void setText(Result result) {
            nameTv.setText(result.getName());
            resultTv.setText(result.getResult());
        }
    }
}
