package com.blueradix.android.monstersapp2initial.rate;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;

import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.blueradix.android.monstersapp2initial.R;
import com.blueradix.android.monstersapp2initial.databinding.RateMonsterScrollingFragmentBinding;
import com.blueradix.android.monstersapp2initial.monster.Monster;

public class RateMonsterScrollingFragment extends Fragment {

    private Monster monster;

    private float rate = 0;

    private RateMonsterScrollingFragmentBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = RateMonsterScrollingFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Bundle bundle = getArguments();
        if (bundle != null && bundle.containsKey("RATE_MONSTER")) {
            monster = (Monster) bundle.getSerializable("RATE_MONSTER");

            binding.rateMonsterNameTextView.setText(monster.getName());

            int resID = binding.getRoot().getResources().getIdentifier(monster.getImage(), "drawable", binding.getRoot().getContext().getPackageName());
            binding.rateMonsterImageView.setImageResource(resID);

            binding.rateMonsterRatingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
                @Override
                public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                    rate = ratingBar.getRating();
                }
            });

            binding.rateMonsterCancelBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    NavController navController = Navigation.findNavController(v);
                    navController.navigate(R.id.action_rateMonsterScrollingFragment_to_showMonstersFragment);
                }
            });

            binding.rateMonsterSaveBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle modifiedBundle = new Bundle();
                    monster.setStars(monster.getStars() + Math.round(rate));
                    monster.setVotes(monster.getVotes() + 1);
                    modifiedBundle.putSerializable("RATED_MONSTER", monster);
                    NavController navController = Navigation.findNavController(v);
                    navController.navigate(R.id.action_rateMonsterScrollingFragment_to_showMonstersFragment, modifiedBundle);
                }
            });
        }
    }
}