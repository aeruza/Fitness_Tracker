package com.example.fitnesstracker.shared.exerciseEntry;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitnesstracker.R;

import java.util.ArrayList;
import java.util.Map;

public class ExerciseEntryDataAdapter extends RecyclerView.Adapter<ExerciseEntryDataViewHolder> {

    ArrayList<ExerciseEntryData> eData;

    EntryClickListener clickListener;
    public ExerciseEntryDataAdapter(ArrayList<ExerciseEntryData> data) {
        this.eData = data;
//        this.clickListener = listener;
    }

    public static class EntryClickListener {
        public void onEntryClick(int position) {};
    }

    @NonNull
    @Override
    public ExerciseEntryDataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View v = layoutInflater.inflate(R.layout.exercise_entry_layout, parent, false);
        ExerciseEntryDataViewHolder dataViewHolder = new ExerciseEntryDataViewHolder(v);
        return dataViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ExerciseEntryDataViewHolder holder, int position) {
        ExerciseEntryData data = eData.get(position);
        holder.date.setText(data.getDate());
        holder.index.setText(String.valueOf(data.getIndex()));
        holder.exerciseName.setText(data.getName());
        holder.total.setText(String.valueOf(data.getTotal()));

//        holder.itemView.setOnClickListener(v -> clickListener.onEntryClick(holder.getAdapterPosition()));

//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                clickListener.onEntryClick(holder.getAdapterPosition());
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return eData.size();
    }
}
