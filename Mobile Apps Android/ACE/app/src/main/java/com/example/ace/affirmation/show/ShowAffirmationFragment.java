package com.example.ace.affirmation.show;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ShowAffirmationFragment extends Fragment {

    private ShowAffirmationViewModel aViewModel;
    private ShowAffirmationFragmentBinding binding;
    private FirebaseAuth mAuth;

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
            // Handle the updated list of affirmations
            Log.i("firebase-db", "Affirmations updated: " + affirmations);
        });

        // Observe randomAffirmation
        aViewModel.getRandomAffirmation().observe(getViewLifecycleOwner(), randomAffirmation -> {
            // Handle the updated random affirmation
            Log.i("firebase-db", "Random affirmation: " + randomAffirmation);
        });



        // temp
        binding.logOutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                // navigate to login
                navController.navigate(R.id.action_showAffirmationFragment_to_loginFragment);
                Toast.makeText(getContext(), "Logout Successful", Toast.LENGTH_SHORT).show();
            }
        });
    }
}