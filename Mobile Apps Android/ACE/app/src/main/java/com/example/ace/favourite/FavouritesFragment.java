package com.example.ace.favourite;

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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ace.R;
import com.example.ace.affirmation.show.ShowAffirmationViewModel;
import com.example.ace.databinding.FavouritesFragmentBinding;
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

    // programmatically create and add chips to ChipGroup
    private void createChips(String[] chipTexts, ChipGroup chipGroup) {
        chipGroup.removeAllViews();
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
                Log.i("firebase-favourie", "Favourites: " + favourites);

                // hide no favourites text
                binding.noFavouritesTextView.setVisibility(View.GONE);

                // cleanup
                binding.affirmationsContainer.removeAllViews();

                // iterate over all favourites and get affirmation by affirmationID for each
                for (Favourite favourite : favourites) {
                    aViewModel.getAffirmationByID(favourite.getAffirmationID()).observe(getViewLifecycleOwner(), affirmation -> {
                        if (affirmation != null) {
                            Log.i("firebase-favourite", "Affirmation: " + affirmation);

                            // set random colour
                            colours = new int[] {
                                    ContextCompat.getColor(requireContext(), R.color.red1),
                                    ContextCompat.getColor(requireContext(), R.color.red2),
                                    ContextCompat.getColor(requireContext(), R.color.blue1),
                                    ContextCompat.getColor(requireContext(), R.color.blue2),
                                    ContextCompat.getColor(requireContext(), R.color.green1),
                                    ContextCompat.getColor(requireContext(), R.color.green2),
                            };

                            // inflate the affirmation layout (this one was so weird to figure out with trial and error...plus i think I did it wrong but it works lol)
                            View affirmationView = LayoutInflater.from(getContext()).inflate(R.layout.item_affirmation, binding.affirmationsContainer, false);
                            TextView textView = affirmationView.findViewById(R.id.affirmation_text_view);
                            ImageView favouriteBtn = affirmationView.findViewById(R.id.favourites_favourite_affirmation_btn);
                            ChipGroup chipGroup = affirmationView.findViewById(R.id.affirmation_chip_group);

                            // set affirmation text
                            textView.setText(affirmation.getText());

                            // handle update favourite
                            favouriteBtn.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    // remove favourite
                                    fViewModel.removeFavourite(currentUser.getUid(), affirmation.getId(), new FavouriteRepository.FavouriteOperationCallback() {
                                        @Override
                                        public void onSuccess() {
                                            // remove favourite view
                                            binding.affirmationsContainer.removeView(affirmationView);
                                            Toast.makeText(getContext(), "Favourite removed successfully!", Toast.LENGTH_SHORT).show();
                                        }
                                        @Override
                                        public void onFailure(Exception e) {
                                            Toast.makeText(getContext(), "Failed to remove favourite: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                                        }
                                    });

                                }
                            });

                            // create chips for tags
                            createChips(affirmation.getTags().toArray(new String[0]), chipGroup);

                            // add affirmation view to the container
                            binding.affirmationsContainer.addView(affirmationView);
                        } else {
                            Log.i("firebase-favourite", "Affirmation: none");
                        }
                    });
                }
            } else {
                Log.i("firebase-favourite", "No favourites found for the user.");
            }
        });
    }
}