package com.example.fitnesstracker.ui.tracker;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitnesstracker.databinding.FragmentTrackerBinding;
import com.example.fitnesstracker.shared.exerciseEntry.ExerciseEntryData;
import com.example.fitnesstracker.shared.exerciseEntry.ExerciseEntryDataAdapter;

import java.util.ArrayList;
import java.util.Random;

public class TrackerFragment extends Fragment {

    ArrayList<ExerciseEntryData> eData = new ArrayList<>();

    private FragmentTrackerBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        TrackerViewModel trackerViewModel =
            new ViewModelProvider(this).get(TrackerViewModel.class);

        binding = FragmentTrackerBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        Random rand = new Random();
        int i;
        for(i = 0; i < 10; i++) {
            int n = rand.nextInt(100) + 1;
            eData.add(i, new ExerciseEntryData(i + 1, "Filler", n));
        }

        // Setting up / Intialising Recyclerview and Adapter
        final RecyclerView recyclerView = binding.trackerRecyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager((getContext())));
        ExerciseEntryDataAdapter adapter = new ExerciseEntryDataAdapter(eData);
        recyclerView.setAdapter(adapter);

//        final ExerciseEntryDataAdapter.EntryClickListener listener = new ExerciseEntryDataAdapter.EntryClickListener() {
//            @Override
//            public void onEntryClick(int position) {
//                Toast.makeText(getContext(), "index: " + position, Toast.LENGTH_LONG).show();
//            }
//        };

        Button addButton = binding.trackerRecyclerViewAddEntryButton;

        addButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
//               int position = recyclerView.getAdapter().getItemCount();
               int position = eData.size();
               ExerciseEntryData newEntry = new ExerciseEntryData(position + 1, "New Entry " + (int)(position+1), rand.nextInt(100) + 1);
               eData.add(newEntry);
               adapter.notifyItemInserted(eData.size() - 1);
           }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}