package com.example.jetpacklivadata.ui.main;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jetpacklivadata.R;
import com.example.jetpacklivadata.databinding.MainFragmentBinding;

public class MainFragment extends Fragment {

    private MainViewModel mViewModel;

    private MainFragmentBinding binding;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // return inflater.inflate(R.layout.main_fragment, container, false);
        binding = MainFragmentBinding.inflate(inflater, container, false); // the magic happens here
        return binding.getRoot();
    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        // create observer to observe the view model and update UI
        final Observer<String> amountObserver = new Observer<String>() {
            @Override
            public void onChanged(String value) {
                binding.totalTextView.setText(value);
            }
        };
        // link amount observer to amount property in main view model
        mViewModel.getTotal().observe(getViewLifecycleOwner(), amountObserver);

        binding.doubleItBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String amountString = binding.amountTextInputEditText.getEditableText().toString();
                // handle inputted nums
                if (!TextUtils.isEmpty(amountString)) {
                    try {
                        double amount = Double.valueOf(amountString);
                        // update view model to trigger observer
                        mViewModel.setTotal(String.valueOf(amount * 2));
                        // clear text input
                        binding.amountTextInputEditText.getText().clear();
                    } catch(Exception e) {
                        Log.i("MyApp", "We could not convert " + amountString + " to a number");
                    }
                }
                // handle if a double as already been calculated
                else if (amountString.equals("") && mViewModel.getTotal() != null) {
                    try {
                        // Get the current total value from the ViewModel
                        String currentAmountString = mViewModel.getTotal().getValue();
                        // Convert the current amount value to double
                        double doubleAmount = Double.parseDouble(currentAmountString);
                        // double the double lol
                        double newDoubledValue = doubleAmount * 2;
                        // convert back to string
                        String newAmount = String.valueOf(newDoubledValue);

                        // update view model to trigger observer
                        mViewModel.setTotal(newAmount);
                    } catch(Exception e) {
                        Log.i("MyApp", "Something went wrong lol");
                    }
                }
            }
        });
    }
}