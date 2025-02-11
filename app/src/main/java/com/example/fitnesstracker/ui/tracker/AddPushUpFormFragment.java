package com.example.fitnesstracker.ui.tracker;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.fitnesstracker.Globals;
import com.example.fitnesstracker.R;

import org.jetbrains.annotations.Nullable;

public class AddPushUpFormFragment extends Fragment {

    private EditText etAddPushups, etPortionSize;
    private Button btnAddPushups;
    private NavController navController;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);
        navController = Navigation.findNavController(view);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.form_add_pushup, container, false);

        // Initialize UI elements
        etAddPushups = view.findViewById(R.id.et_num_pushups);
        btnAddPushups = view.findViewById(R.id.btn_add_pushups);

        // Button click logic for adding a meal
        btnAddPushups.setOnClickListener(v -> addPushups());

        return view;
    }

    private void addPushups() {
        // Logic for adding pushups to the total log and updating the RecyclerView
        // Validate input and add to the global var (add Room database persistence here later)
        int numPushups = Integer.parseInt(etAddPushups.getText().toString());
        Globals.totalPushups += numPushups;

        Toast.makeText(getActivity(), "Added: " + numPushups, Toast.LENGTH_SHORT).show();

        navController.navigate(R.id.navigation_tracker);

        // Update RecyclerView to reflect the new entry
    }

}
