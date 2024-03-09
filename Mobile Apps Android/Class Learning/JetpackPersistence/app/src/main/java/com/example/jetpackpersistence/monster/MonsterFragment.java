package com.example.jetpackpersistence.monster;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.jetpackpersistence.R;
import com.example.jetpackpersistence.databinding.MonsterFragmentBinding;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class MonsterFragment extends Fragment {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
    private MonsterViewModel mViewModel;
    private MonsterFragmentBinding binding;

    public static MonsterFragment newInstance() {
        return new MonsterFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = MonsterFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(MonsterViewModel.class);

        final Observer<List<Monster>> allMonstersObserver = new Observer<List<Monster>>() {
            @Override
            public void onChanged(List<Monster> monsters) {
                binding.totalOfMonstersTextView.setText("Total monsters registered:" + monsters.size());
            }
        };
        mViewModel.getAllMonsters().observe(getViewLifecycleOwner(), allMonstersObserver);

        binding.findMonsterByIdButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = binding.monsterIdEditText.getText().toString();
                Monster monster = mViewModel.findById(Integer.parseInt(id));
                // monster found
                if (monster != null) {
                    binding.selectedMonsterTextView.setText("ID: " + monster.getId() + ", Name: " + monster.getName() + ", Description: " + monster.getDescription());
                } else {
                    Toast.makeText(getContext(), "Monster ID not found", Toast.LENGTH_LONG).show();
                }
            }
        });

        binding.testAddMonsterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Timestamp timestamp = new Timestamp(new Date().getTime());
                mViewModel.insert(new Monster("Rando " + DATE_FORMAT.format(timestamp), "Test", "", 2, 2, 2));
            }
        });

        binding.deleteMonsterByIdButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = binding.monsterIdEditText.getText().toString();
                Monster monster = mViewModel.findById(Integer.parseInt(id));
                // monster found
                if (monster != null) {
                    mViewModel.delete(monster);
                } else {
                    Toast.makeText(getContext(), "Monster ID not found", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}