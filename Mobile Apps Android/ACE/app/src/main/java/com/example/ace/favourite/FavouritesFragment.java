package com.example.ace.favourite;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ace.R;
import com.example.ace.databinding.FavouritesFragmentBinding;
import com.example.ace.databinding.ShowAffirmationFragmentBinding;

public class FavouritesFragment extends Fragment {

    private FavouritesFragmentBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FavouritesFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        NavController navController = Navigation.findNavController(view);

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
    }
}