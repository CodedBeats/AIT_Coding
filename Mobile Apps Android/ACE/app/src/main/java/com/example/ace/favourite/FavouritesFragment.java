package com.example.ace.favourite;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ace.R;
import com.example.ace.affirmation.Affirmation;
import com.example.ace.affirmation.AffirmationRepository;
import com.example.ace.affirmation.show.ShowAffirmationViewModel;
import com.example.ace.databinding.FavouritesFragmentBinding;
import com.example.ace.databinding.ShowAffirmationFragmentBinding;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Random;

public class FavouritesFragment extends Fragment {

    private FavouriteViewModel fViewModel;
    private ShowAffirmationViewModel aViewModel;
    private FavouritesFragmentBinding binding;
    private FirebaseAuth uAuth;
    private int[] colours;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        uAuth = FirebaseAuth.getInstance();
        binding = FavouritesFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    // get random colour
    private int getRandomColor() {
        Random rand = new Random();
        return colours[rand.nextInt(colours.length)];
    }

    // Programmatically create and add chips to the ChipGroup
    private void createChips(String[] chipTexts, ChipGroup chipGroup) {
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
        fViewModel = new ViewModelProvider(this).get(FavouriteViewModel.class);
        aViewModel = new ViewModelProvider(this).get(ShowAffirmationViewModel.class);

        // setup nav
        binding.bottomNavigation.setOnNavigationItemSelectedListener(item -> {
            if (item.getItemId() == R.id.navigation_home) {
                navController.navigate(R.id.action_favouritesFragment_to_showAffirmationFragment);
                return true;
            }
            if (item.getItemId() == R.id.navigation_profile) {
                navController.navigate(R.id.action_favouritesFragment_to_userFragment);
                return true;
            }
            return false;
        });

        // Observe all favourites where userID is current user
        FirebaseUser currentUser = uAuth.getCurrentUser();
        fViewModel.getFavouritesByUserID(currentUser.getUid()).observe(getViewLifecycleOwner(), favourites -> {
            if (favourites != null && !favourites.isEmpty()) {
                Log.i("firebase-db", "Favourites: " + favourites);

                // hide no favourites text
                binding.noFavouritesTextView.setVisibility(View.GONE);

                // Clear the container before adding new views
                binding.affirmationsContainer.removeAllViews();

                // Iterate over all favourites and get affirmation by ID for each
                for (Favourite favourite : favourites) {
                    aViewModel.getAffirmationByID(favourite.getAffirmationID()).observe(getViewLifecycleOwner(), affirmation -> {
                        if (affirmation != null) {
                            Log.i("firebase-db", "Affirmation: " + affirmation);

                            // set random colour
                            colours = new int[] {
                                    ContextCompat.getColor(requireContext(), R.color.red1),
                                    ContextCompat.getColor(requireContext(), R.color.red2),
                                    ContextCompat.getColor(requireContext(), R.color.blue1),
                                    ContextCompat.getColor(requireContext(), R.color.blue2),
                                    ContextCompat.getColor(requireContext(), R.color.green1),
                                    ContextCompat.getColor(requireContext(), R.color.green2),
                            };

                            // Inflate the affirmation layout
                            View affirmationView = LayoutInflater.from(getContext()).inflate(R.layout.item_affirmation, binding.affirmationsContainer, false);
                            TextView textView = affirmationView.findViewById(R.id.affirmation_text_view);
                            ChipGroup chipGroup = affirmationView.findViewById(R.id.affirmation_chip_group);

                            // Set the affirmation text
                            textView.setText(affirmation.getText());

                            // Create chips for the tags
                            createChips(affirmation.getTags().toArray(new String[0]), chipGroup);

                            // Add the affirmation view to the container
                            binding.affirmationsContainer.addView(affirmationView);
                        } else {
                            Log.i("firebase-db", "Affirmation: none");
                        }
                    });
                }
            } else {
                Log.i("firebase-db", "No favourites found for the user.");
            }
        });


    }
}