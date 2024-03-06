package com.blueradix.android.jetpack_4_navigationcomponent.ui.main;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blueradix.android.jetpack_4_navigationcomponent.databinding.MainFragmentBinding;

public class MainFragment extends Fragment {

    private MainViewModel mViewModel;
    private MainFragmentBinding binding;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = MainFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        //get the id of the button from the view


        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //if the class MainToDragons does not appear, clean and rebuild the project, safeargs will generate it
                MainFragmentDirections.MainToDragons action = MainFragmentDirections.mainToDragons();
                action.setMessage(binding.userTextInputEditText.getText().toString());
                //pass an attribute
                Navigation.findNavController(view).navigate(action);

            }
        });
        /*
        you can also use:
        createNavigateOnClickListener() to set up the button listener and navigate to
        a destination

        button.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.mainToSecond, null)

        */
    }



}
