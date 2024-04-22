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

import android.text.InputType;
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


        // update password


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
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle("Confirm Account Deletion");
                builder.setMessage("Are you sure you want to delete your account? Enter your password to confirm:");

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
                            // User auth successful -> delete all user data
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