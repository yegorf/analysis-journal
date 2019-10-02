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

public class DirectoryAdapter extends RecyclerView.Adapter<DirectoryAdapter.AnalysisHolder> {

    private List<Analysis> directory;
    private LayoutInflater inflater;
    private Context context;

    public DirectoryAdapter(List<Analysis> directory, Context context) {
        this.directory = directory;
        this.inflater = LayoutInflater.from(context);
        this.context = context;
    }

    @NonNull
    @Override
    public AnalysisHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.holer_directory, parent, false);
        context = view.getContext();
        return new DirectoryAdapter.AnalysisHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnalysisHolder holder, int position) {
        Analysis analysis = directory.get(position);
        holder.setText(analysis);
    }

    @Override
    public int getItemCount() {
        return directory.size();
    }

    class AnalysisHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_analysis_name)
        TextView name;

        @BindView(R.id.tv_analysis_norma)
        TextView norma;

        AnalysisHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void setText(Analysis analysis) {
            name.setText(analysis.getName());
            norma.setText(analysis.getResult());
        }
    }
}
