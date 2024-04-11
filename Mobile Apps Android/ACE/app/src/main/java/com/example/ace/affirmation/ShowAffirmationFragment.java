package com.example.ace.affirmation;

import androidx.lifecycle.ViewModelProvider;

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
import com.example.ace.databinding.ShowAffirmationFragmentBinding;

public class ShowAffirmationFragment extends Fragment {

    private ShowAffirmationViewModel mViewModel;
    private ShowAffirmationFragmentBinding binding;

    public static ShowAffirmationFragment newInstance() {
        return new ShowAffirmationFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.show_affirmation_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        // navigate to register if user not logged in
        NavController navController = Navigation.findNavController(view);
        // get auth logic
        boolean userIsLoggedIn = false;
        if (!userIsLoggedIn) {
            navController.navigate(R.id.action_showAffirmationFragment_to_registerFragment2);
        }
    }
}