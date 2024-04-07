package com.blueradix.android.monstersapp2initial.monster.show;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blueradix.android.monstersapp2initial.R;
import com.blueradix.android.monstersapp2initial.databinding.ShowMonstersFragmentBinding;
import com.blueradix.android.monstersapp2initial.monster.Monster;

import java.util.List;

public class ShowMonstersFragment extends Fragment implements OnItemClickListener {

    private ShowMonstersViewModel mViewModel;
    private ShowMonstersFragmentBinding binding;

    public static ShowMonstersFragment newInstance() {
        return new ShowMonstersFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = ShowMonstersFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(ShowMonstersViewModel.class);


        Bundle bundle = getArguments();
        if(bundle != null && bundle.containsKey("ADD_MONSTER")){
            // coming back from add monster
            Monster monster = (Monster) bundle.getSerializable("ADD_MONSTER");
            mViewModel.insert(monster);
        }
        if (bundle != null && bundle.containsKey("RATED_MONSTER")) {
            Monster monster = (Monster) bundle.getSerializable("RATED_MONSTER");
            mViewModel.update(monster);
        }


//        binding.monstersRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        binding.monstersRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.monstersRecyclerView.setHasFixedSize(true);

        MonsterRecyclerViewAdapter adapter = new MonsterRecyclerViewAdapter(this);
        binding.monstersRecyclerView.setAdapter(adapter);

        final Observer<List<Monster>> allMonstersObserver = new Observer<List<Monster>>() {
            @Override
            public void onChanged(List<Monster> monsters) {
                // update RecyclerView
                adapter.submitList(monsters);
            }
        };
        mViewModel.getAllMonsters().observe(getViewLifecycleOwner(), allMonstersObserver);

        binding.addMonsterFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController navController = Navigation.findNavController(view);
                navController.navigate(R.id.action_showMonstersFragment_to_addMonsterScrollingFragment);
            }
        });

    }

    @Override
    public void onClick(Monster monster, View view) {
        // log monster on click/tap
//        Log.i("xyz", monster.toString());

        Bundle bundle = new Bundle();
        bundle.putSerializable("RATE_MONSTER", monster);

        NavController navController = Navigation.findNavController(view);
        navController.navigate(R.id.action_showMonstersFragment_to_rateMonsterScrollingFragment, bundle);
    }
}