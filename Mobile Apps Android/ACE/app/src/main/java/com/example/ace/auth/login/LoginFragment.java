package com.example.ace.auth.login;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.ace.R;
import com.example.ace.databinding.LoginFragmentBinding;
import com.example.ace.databinding.RegisterFragmentBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class LoginFragment extends Fragment {

    LoginFragmentBinding binding;
    FirebaseAuth mAuth;
    ProgressBar progressBar;
    LinearLayout bottomNav;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = LoginFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        NavController navController = Navigation.findNavController(view);
        mAuth = FirebaseAuth.getInstance();

        // hide nav



        // link to register
        binding.notRegisteredTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_loginFragment_to_registerFragment);
            }
        });

        // handle login submit
        binding.signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // show progress bar
                binding.progressBar.setVisibility(View.VISIBLE);

                // get text
                String email, password;
                email = String.valueOf(binding.emailTextInput.getText());
                password = String.valueOf(binding.passwordTextInput.getText());

                // validate email and password aren't empty
                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getContext(), "Enter Email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getContext(), "Enter Password", Toast.LENGTH_SHORT).show();
                    return;
                }


                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // hide progress bar
                                    binding.progressBar.setVisibility(View.GONE);

                                    Toast.makeText(getContext(), "Login successful", Toast.LENGTH_SHORT).show();
                                    // navigate to home
                                    navController.navigate(R.id.action_loginFragment_to_showAffirmationFragment);

                                } else {
                                    // hide progress bar
                                    binding.progressBar.setVisibility(View.GONE);

                                    String errorMessage = task.getException().getMessage();
                                    Log.i("XYZ", errorMessage);
                                    Toast.makeText(getContext(), "Login Failed", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
    }
}