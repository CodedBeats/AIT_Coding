package com.example.ace.user;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.ace.R;
import com.example.ace.databinding.FavouritesFragmentBinding;
import com.example.ace.databinding.UserFragmentBinding;
import com.google.firebase.auth.FirebaseAuth;


public class UserFragment extends Fragment {

    UserFragmentBinding binding;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = UserFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        NavController navController = Navigation.findNavController(view);

        // setup nav
        binding.bottomNavigation.setOnNavigationItemSelectedListener(item -> {
            if (item.getItemId() == R.id.navigation_home) {
                navController.navigate(R.id.action_userFragment_to_showAffirmationFragment);
                return true;
            }
            if (item.getItemId() == R.id.navigation_favourites) {
                navController.navigate(R.id.action_userFragment_to_favouritesFragment);
                return true;
            }
            return false;
        });

        // display user info


        // handle logout
        binding.logOutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                // navigate to login
                navController.navigate(R.id.action_userFragment_to_loginFragment);
                Toast.makeText(getContext(), "Logout Successful", Toast.LENGTH_SHORT).show();
            }
        });
    }
}