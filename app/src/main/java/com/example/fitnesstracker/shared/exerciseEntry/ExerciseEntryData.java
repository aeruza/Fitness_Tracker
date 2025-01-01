package com.example.fitnesstracker.shared.exerciseEntry;

import java.util.Date;

public class ExerciseEntryData {

    private String date;
    private int index;
    private String exerciseName;
    private int total;

    public ExerciseEntryData(String date, int index, String exerciseName, int total) {
        this.date = date;
        this.index = index;
        this.exerciseName = exerciseName;
        this.total = total;
    }

    public String getDate() {
        return this.date;
    }

    public int getIndex() {
        return this.index;
    }

    public void setIndex(int newI) {
        this.index = newI;
    }

    public String getName() {
        return this.exerciseName;
    }

    public int getTotal() {
        return this.total;
    }

    public void setTotal(int newTotal) {
        this.total = newTotal;
    }
}
