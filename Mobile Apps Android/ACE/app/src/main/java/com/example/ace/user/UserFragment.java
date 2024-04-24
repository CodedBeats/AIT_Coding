package com.example.ace.user;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ace.R;
import com.example.ace.affirmation.show.ShowAffirmationViewModel;
import com.example.ace.databinding.FavouritesFragmentBinding;
import com.example.ace.databinding.UserFragmentBinding;
import com.example.ace.favourite.FavouriteRepository;
import com.example.ace.favourite.FavouriteViewModel;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class UserFragment extends Fragment {

    private UserViewModel uViewModel;
    private FavouriteViewModel fViewModel;
    private UserFragmentBinding binding;
    private FirebaseAuth uAuth;
    private FirebaseUser currentUser;


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
        uViewModel = new ViewModelProvider(this).get(UserViewModel.class);
        fViewModel = new ViewModelProvider(this).get(FavouriteViewModel.class);


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

        // observe user
        uViewModel.getUser().observe(getViewLifecycleOwner(), user -> {
            // display email (and fake password lol)
            binding.userEmailTextView.setText(user.getEmail());
        });


        /*
        * Update password and delete account are handled sort of differently.
        * I don't know which way would be the jetpack way so I kinda just did both lol.
        * For update password the re-auth is handled in the repository,
        * For delete account the re-auth is handled in the fragment.
        * Both ways get the password from the view and passed with the fragment which I believe is the correct way,
        * But not sure where the re-auth should be called so here is both ways :p
        */


        // disable update password btn until input is not null
        binding.updatePasswordBtn.setEnabled(false);
        // fancy way to make sure update password btn won't submit null (maybe not necessary but I like it)
        binding.updatePasswordTextInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // fancy fancy fancy
                String userInput = binding.updatePasswordTextInput.getText().toString();
                boolean isWhitespaceOnly = userInput.matches("^\\s*$");
                // enable the button if it's not empty/just spaces
                binding.updatePasswordBtn.setEnabled(!isWhitespaceOnly);
            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        // handle update password
        binding.updatePasswordBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // modal to re-auth user
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle("Change Password");
                builder.setMessage("Please enter your current password to proceed");

                // input field for password
                final EditText input = new EditText(getContext());
                input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                builder.setView(input);

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // get entered password
                        String enteredPassword = input.getText().toString();
                        // handle empty/null input
                        if (enteredPassword.isEmpty()) {
                            enteredPassword = "blank";
                        }
                        uViewModel.updateUserPassword(binding.updatePasswordTextInput.getText().toString(), enteredPassword, new UserRepository.UserOperationCallback() {
                            @Override
                            public void onSuccess() {
                                // clear input and change focus, also disable update btn
                                binding.updatePasswordTextInput.setText("");
                                binding.updatePasswordTextInput.clearFocus();
                                binding.updatePasswordBtn.setEnabled(false);

                                Toast.makeText(getContext(), "Password Update Successful", Toast.LENGTH_SHORT).show();
                                Log.i("firebase-db", "Password Update Successful");
                            }

                            @Override
                            public void onFailure(Exception e) {
                                Toast.makeText(getContext(), "Update failed: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                                Log.i("firebase-db", e.getMessage());
                            }
                        });
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // user canceled -> do nothing
                    }
                });

                builder.show();
            }
        });


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


        // handle delete account
        binding.deleteAccountBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // modal to re-auth user
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle("Confirm Account Deletion");
                builder.setMessage("Are you sure you want to delete your account? Enter your password to confirm");

                // input field for password
                final EditText input = new EditText(getContext());
                input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                builder.setView(input);

                // set userID
                String userID = uViewModel.getUser().getValue().getUserID();

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // get entered password
                        String enteredPassword = input.getText().toString();
                        // handle empty/null input
                        if (enteredPassword.isEmpty()) {
                            enteredPassword = "blank";
                        }

                        // re-auth user
                        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
                        AuthCredential credential = EmailAuthProvider.getCredential(currentUser.getEmail(), enteredPassword);

                        currentUser.reauthenticate(credential).addOnSuccessListener(authResult -> {
                            // user auth successful -> delete all user data
                            // delete user
                            uViewModel.deleteUser(currentUser, new UserRepository.UserOperationCallback() {
                                @Override
                                public void onSuccess() {
                                    Log.i("firebase-db", "account removed");

                                    // delete user's favourites
                                    fViewModel.removeAllUserFavourites(userID, new FavouriteRepository.FavouriteOperationCallback() {
                                        @Override
                                        public void onSuccess() {
                                            Log.i("firebase-db", "user's favourites removed");
                                        }

                                        @Override
                                        public void onFailure(Exception e) {
                                            Log.i("firebase-db", e.getMessage());
                                        }
                                    });

                                    Toast.makeText(getContext(), "Your account was deleted successfully!", Toast.LENGTH_SHORT).show();
                                    FirebaseAuth.getInstance().signOut();
                                    // navigate to login screen
                                    navController.navigate(R.id.action_userFragment_to_loginFragment);
                                }

                                @Override
                                public void onFailure(Exception e) {
                                    Toast.makeText(getContext(), "Remove account failed: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                                    Log.i("firebase-db", e.getMessage());
                                }
                            });
                        })
                        .addOnFailureListener(e -> {
                            // auth failed
                            Toast.makeText(getContext(), "Incorrect Password", Toast.LENGTH_SHORT).show();
                            Log.i("firebase-db", e.getMessage());
                        });
                    }
                });

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // user canceled -> do nothing
                    }
                });

                builder.show();
            }
        });
    }
}