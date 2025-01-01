package com.example.fitnesstracker.shared.exerciseEntry;

public class ExerciseEntryData {
    private int index;
    private String exerciseName;
    private int total;

    public ExerciseEntryData(int index, String exerciseName, int total) {
        this.index = index;
        this.exerciseName = exerciseName;
        this.total = total;
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
