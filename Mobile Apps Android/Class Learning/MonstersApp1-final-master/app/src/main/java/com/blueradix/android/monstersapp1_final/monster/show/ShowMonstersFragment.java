package com.blueradix.android.monstersapp1_final.monster.show;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blueradix.android.monstersapp1_final.databinding.ShowMonstersFragmentBinding;
import com.blueradix.android.monstersapp1_final.monster.Monster;

import java.util.List;

public class ShowMonstersFragment extends Fragment {

    private ShowMonstersViewModel mViewModel;
    private ShowMonstersFragmentBinding binding;


    public static ShowMonstersFragment newInstance() {
        return new ShowMonstersFragment();
    }

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

//      configure the Recycler View
        binding.monstersRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.monstersRecyclerView.setHasFixedSize(true);
//      set the adapter to the Recycler View
        MonsterRecyclerViewAdapter adapter = new MonsterRecyclerViewAdapter();
        binding.monstersRecyclerView.setAdapter(adapter);

        final Observer<List<Monster>> allMonstersObserver = new Observer<List<Monster>>() {
            @Override
            public void onChanged(List<Monster> monsters) {
                // update RecyclerView, submitList compares the oldList(in the recyclerView)
                // with the new list coming from the database, and it will calculate at which
                // position the list has changed, so we don't redraw the whole recyclerView
                // just the Monsters that changed.
                adapter.submitList(monsters);
            }
        };
        mViewModel.getAllMonsters().observe(getViewLifecycleOwner(), allMonstersObserver);

    }

}