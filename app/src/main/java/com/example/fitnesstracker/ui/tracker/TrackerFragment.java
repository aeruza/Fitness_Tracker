package com.example.fitnesstracker.ui.tracker;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitnesstracker.Globals;
import com.example.fitnesstracker.R;
import com.example.fitnesstracker.databinding.FragmentTrackerBinding;
import com.example.fitnesstracker.shared.exerciseEntry.ExerciseEntryData;
import com.example.fitnesstracker.shared.exerciseEntry.ExerciseEntryDataAdapter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class TrackerFragment extends Fragment {

    ArrayList<ExerciseEntryData> eData = new ArrayList<>();
    String date = new SimpleDateFormat("dd-MM-yyyy, hh:mm", Locale.getDefault()).format(new Date());

    private FragmentTrackerBinding binding;
    private NavController navController;


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);
        navController = Navigation.findNavController(view);
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        TrackerViewModel trackerViewModel =
            new ViewModelProvider(this).get(TrackerViewModel.class);


        binding = FragmentTrackerBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        TextView totalPushups = binding.trackerTextView;
        totalPushups.setText("Total: " + Globals.totalPushups);

        Random rand = new Random();
        int i;
        for(i = 0; i < 10; i++) {
            eData.add(i, new ExerciseEntryData(date, i + 1, "Filler", rand.nextInt(100) + 1));
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
               // Show the form to input number of pushups
               navController.navigate(R.id.navigation_form_add_pushups);
//               int position = recyclerView.getAdapter().getItemCount();
//               int position = eData.size();
//               ExerciseEntryData newEntry = new ExerciseEntryData(date, position + 1, "New Entry " + (position+1), rand.nextInt(100) + 1);
//               eData.add(newEntry);
//               adapter.notifyItemInserted(eData.size() - 1);
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