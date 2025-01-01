package com.example.fitnesstracker.ui.stats;

import android.icu.text.DateFormat;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.example.fitnesstracker.databinding.FragmentStatsBinding;
import com.example.fitnesstracker.databinding.FragmentTrackerBinding;
import com.example.fitnesstracker.ui.tracker.TrackerViewModel;

import java.util.Date;

public class StatsFragment extends Fragment {

private FragmentStatsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        StatsViewModel statsViewModel =
                new ViewModelProvider(this).get(StatsViewModel.class);

    binding = FragmentStatsBinding.inflate(inflater, container, false);
    View root = binding.getRoot();

        final TextView textView = binding.textStats;
        statsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    public String getDate() {
        Date d = new Date();
        return "";
        // String currentDate = String.format(String.valueOf(d.getDate()));
        // return currentDate;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}