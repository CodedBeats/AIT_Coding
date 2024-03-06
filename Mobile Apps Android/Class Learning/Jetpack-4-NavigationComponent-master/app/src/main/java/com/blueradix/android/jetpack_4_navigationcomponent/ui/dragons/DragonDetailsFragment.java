package com.blueradix.android.jetpack_4_navigationcomponent.ui.dragons;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.blueradix.android.jetpack_4_navigationcomponent.Model.Dragon;
import com.blueradix.android.jetpack_4_navigationcomponent.databinding.DragonDetailsFragmentBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class DragonDetailsFragment extends Fragment {

    private DragonDetailsFragmentBinding binding;

    public static DragonDetailsFragment newInstance() {
        // Required empty public constructor
        return new DragonDetailsFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DragonDetailsFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        /*
        This is without safeargs, we will need the key to get the object passed, therefore it's not type safe
        Bundle arguments = this.getArguments();
        Dragon drag = (Dragon)arguments.getSerializable("drag");
        */

        DragonDetailsFragmentArgs args = DragonDetailsFragmentArgs.fromBundle(getArguments());
        Dragon dragon = args.getDragon();

        binding.nameTextView.setText(dragon.getName());
        binding.descTextView.setText(dragon.getDescription());
        binding.dragonImageView.setImageResource(dragon.getResId());
        binding.typeTextView.setText(dragon.getType().toString());

    }
}
