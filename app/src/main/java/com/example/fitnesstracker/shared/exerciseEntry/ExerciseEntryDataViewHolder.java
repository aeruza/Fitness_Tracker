package com.example.fitnesstracker.shared.exerciseEntry;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitnesstracker.R;


public class ExerciseEntryDataViewHolder extends RecyclerView.ViewHolder {

    public TextView index;
    public TextView exerciseName;
    public TextView total;

    public ExerciseEntryDataViewHolder(@NonNull View view) {
        super(view);
        index = (TextView)view.findViewById(R.id.exercise_entry_index);
        exerciseName = (TextView)view.findViewById(R.id.exercise_entry_name);
        total = (TextView)view.findViewById(R.id.exercise_entry_total);
    }
}
