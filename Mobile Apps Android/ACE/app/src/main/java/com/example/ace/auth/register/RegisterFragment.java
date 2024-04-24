package com.example.ace.auth.register;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.ace.R;
import com.example.ace.databinding.RegisterFragmentBinding;
import com.example.ace.user.UserViewModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class RegisterFragment extends Fragment {

    private UserViewModel uViewModel;
    private RegisterFragmentBinding binding;
    FirebaseAuth uAuth;
    ProgressBar progressBar;
    LinearLayout bottomNav;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = RegisterFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        NavController navController = Navigation.findNavController(view);
        uViewModel = new ViewModelProvider(this).get(UserViewModel.class);
        uAuth = FirebaseAuth.getInstance();

        // link to login screen
        binding.alreadyRegisteredTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_registerFragment_to_loginFragment);
            }
        });

        // handle register submit
        binding.signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // show progress bar
                binding.progressBar.setVisibility(View.VISIBLE);

                // get text
                String email, password, confirmPassword;
                email = String.valueOf(binding.emailTextInput.getText());
                password = String.valueOf(binding.passwordTextInput.getText());
                confirmPassword = String.valueOf(binding.confirmPasswordTextInput.getText());

                // validate email and password aren't empty
                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getContext(), "Enter Email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getContext(), "Enter Password", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(confirmPassword)) {
                    Toast.makeText(getContext(), "Confirm Password", Toast.LENGTH_SHORT).show();
                    return;
                }

                // validate inputted password match
                if (!password.equals(confirmPassword)) {
                    Toast.makeText(getContext(), "Passwords don't match", Toast.LENGTH_SHORT).show();
                    return;
                }

                // validate password length (firebase doesn't allow < 6 characters)
                if (password.length() < 6) {
                    Toast.makeText(getContext(), "Password must be at least 6 characters long", Toast.LENGTH_SHORT).show();
                    return;
                }

                // create user
                uAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // user created successfully
                                FirebaseUser newUser = task.getResult().getUser();
                                String userID = newUser.getUid();

                                // create doc of user in userSeenAffirmations with empty array of affirmationsSeen
                                uViewModel.setupUserForSeenAffirmations(userID);

                                // hide progress bar
                                binding.progressBar.setVisibility(View.GONE);

                                Toast.makeText(getContext(), "User created successfully", Toast.LENGTH_SHORT).show();
                                // navigate to home
                                navController.navigate(R.id.action_registerFragment_to_showAffirmationFragment);

                            } else {
                                // hide progress bar
                                binding.progressBar.setVisibility(View.GONE);

                                String errorMessage = task.getException().getMessage();
                                Log.i("firebase-auth", errorMessage);
                                Toast.makeText(getContext(), "Couldn't create user", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
            }
        });
    }
}