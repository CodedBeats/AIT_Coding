package com.example.ace.affirmation.show;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.ace.R;
import com.example.ace.affirmation.Affirmation;
import com.example.ace.affirmation.AffirmationRepository;
import com.example.ace.databinding.ShowAffirmationFragmentBinding;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Objects;
import java.util.Random;

public class ShowAffirmationFragment extends Fragment {

    private ShowAffirmationViewModel aViewModel;
    private ShowAffirmationFragmentBinding binding;
    private FirebaseAuth mAuth;
    private int[] colours;

    public static ShowAffirmationFragment newInstance() {
        return new ShowAffirmationFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        mAuth = FirebaseAuth.getInstance();
        binding = ShowAffirmationFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }


    // get random colour
    private int getRandomColor() {
        Random rand = new Random();
        return colours[rand.nextInt(colours.length)];
    }

    // programmatically create and add chips to the ChipGroup
    private void createChips(String[] chipTexts) {
        ChipGroup chipGroup = binding.chipGroup;
        chipGroup.removeAllViews(); // Clear existing chips

        for (String text : chipTexts) {
            Chip chip = new Chip(getContext());
            chip.setText(text);
            chip.setChipBackgroundColor(ColorStateList.valueOf(getRandomColor()));
            chip.setChipStrokeColor(ColorStateList.valueOf(Color.WHITE));

            chipGroup.addView(chip);
        }
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        NavController navController = Navigation.findNavController(view);
        aViewModel = new ViewModelProvider(this).get(ShowAffirmationViewModel.class);

        // set up navigation
        binding.bottomNavigation.setOnNavigationItemSelectedListener(item -> {
            if (item.getItemId() == R.id.navigation_profile) {
                navController.navigate(R.id.action_showAffirmationFragment_to_userFragment);
                return true;
            }
            if (item.getItemId() == R.id.navigation_favourites) {
                navController.navigate(R.id.action_showAffirmationFragment_to_favouritesFragment);
                return true;
            }
            return false;
        });

        // Check if user is signed in (non-null)
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser == null) {
            navController.navigate(R.id.action_showAffirmationFragment_to_registerFragment);
        }


        // Observe affirmationsLiveData
        aViewModel.getAllAffirmations().observe(getViewLifecycleOwner(), affirmations -> {
            if (affirmations != null) {
                // Handle the updated list of affirmations
                Log.i("firebase-db", "Affirmations updated: " + affirmations);
            }
        });

        // Observe randomAffirmation
        aViewModel.getRandomAffirmation().observe(getViewLifecycleOwner(), randomAffirmation -> {
            if (randomAffirmation != null && randomAffirmation.getText() != null && randomAffirmation.getTags() != null) {
                // Handle the updated random affirmation
                Log.i("firebase-db", "Random affirmation: " + randomAffirmation);

                // display affirmation text
                binding.affirmationTextView.setText(randomAffirmation.getText());

                // get random colour
                colours = new int[] {
                        ContextCompat.getColor(requireContext(), R.color.red1),
                        ContextCompat.getColor(requireContext(), R.color.red2),
                        ContextCompat.getColor(requireContext(), R.color.blue1),
                        ContextCompat.getColor(requireContext(), R.color.blue2),
                        ContextCompat.getColor(requireContext(), R.color.green1),
                        ContextCompat.getColor(requireContext(), R.color.green2),
                };
                // get tags
                String[] tagsArr = randomAffirmation.getTags().toArray(new String[0]);
                // add tags as chips
                createChips(tagsArr);
            }
        });




        // temp
//        binding.logOutBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                FirebaseAuth.getInstance().signOut();
//                // navigate to login
//                navController.navigate(R.id.action_showAffirmationFragment_to_loginFragment);
//                Toast.makeText(getContext(), "Logout Successful", Toast.LENGTH_SHORT).show();
//            }
//        });
    }
}