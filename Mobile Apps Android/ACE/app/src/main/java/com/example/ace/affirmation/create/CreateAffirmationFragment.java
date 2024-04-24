package com.example.ace.affirmation.create;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.ace.R;
import com.example.ace.affirmation.AffirmationRepository;
import com.example.ace.databinding.CreateAffirmationFragmentBinding;
import com.example.ace.databinding.UserFragmentBinding;
import com.example.ace.user.UserViewModel;


public class CreateAffirmationFragment extends Fragment {

    private CreateAffirmationViewModel cViewModel;
    private CreateAffirmationFragmentBinding binding;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = CreateAffirmationFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    // Method to update button state
    private void updateButtonState(boolean isField1Filled, boolean isField2Filled, boolean isField3Filled) {
        if (isField1Filled && isField2Filled && isField3Filled) {
            binding.submitAffirmationBtn.setEnabled(true);
        } else {
            binding.submitAffirmationBtn.setEnabled(false);
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        NavController navController = Navigation.findNavController(view);
        cViewModel = new ViewModelProvider(this).get(CreateAffirmationViewModel.class);


        // setup nav
        binding.bottomNavigation.setOnNavigationItemSelectedListener(item -> {
            if (item.getItemId() == R.id.navigation_home) {
                navController.navigate(R.id.action_createAffirmationFragment_to_showAffirmationFragment);
                return true;
            }
            if (item.getItemId() == R.id.navigation_favourites) {
                navController.navigate(R.id.action_createAffirmationFragment_to_favouritesFragment);
                return true;
            }
            if (item.getItemId() == R.id.navigation_profile) {
                navController.navigate(R.id.action_createAffirmationFragment_to_userFragment);
                return true;
            }
            return false;
        });



        // handle sumbit new affirmation
        binding.submitAffirmationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // handle if any fields are empty
                if (
                    binding.affirmationTextInputField.getText().toString().isEmpty() ||
                    binding.firstTagTextInputField.getText().toString().isEmpty() ||
                    binding.secondTagTextInputField.getText().toString().isEmpty()
                ) {
                    Toast.makeText(getContext(), "Please fill all fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                cViewModel.createAffirmation(
                    binding.affirmationTextInputField.getText().toString(),
                    binding.firstTagTextInputField.getText().toString(),
                    binding.secondTagTextInputField.getText().toString(),
                    new AffirmationRepository.AffirmationOperationCallback() {
                        @Override
                        public void onSuccess() {
                            // clear fields but don't leave page in case user wants to make more affirmations :)
                            binding.affirmationTextInputField.setText("");
                            binding.affirmationTextInputField.clearFocus();
                            binding.firstTagTextInputField.setText("");
                            binding.firstTagTextInputField.clearFocus();
                            binding.secondTagTextInputField.setText("");
                            binding.secondTagTextInputField.clearFocus();

                            Toast.makeText(getContext(), "Created Affirmation Successfully", Toast.LENGTH_SHORT).show();
                            Log.i("firebase-affirmation", "affirmation added");
                        }
                        @Override
                        public void onFailure(Exception e) {
                            Toast.makeText(getContext(), "create affirmation failed", Toast.LENGTH_SHORT).show();
                            Log.i("firebase-affirmation", "create affirmation failed: " + e.getMessage());
                        }
                    }
                );
            }
        });


    }
}