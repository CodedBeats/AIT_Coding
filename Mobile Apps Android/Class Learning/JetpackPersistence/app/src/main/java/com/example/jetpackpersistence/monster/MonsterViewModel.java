package com.example.jetpackpersistence.monster;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.jetpackpersistence.MonsterRepository;

import java.util.List;

public class MonsterViewModel extends AndroidViewModel {

    private MonsterRepository monsterRepository;

    private LiveData<List<Monster>> allMonsters;

    public MonsterViewModel(@NonNull Application application) {
        super(application);
        monsterRepository = new MonsterRepository(application);
        allMonsters = monsterRepository.getAllMonsters();
    }


    public void insert(Monster monster) {
        monsterRepository.insert(monster);
    }

    public void update(Monster monster) {
        monsterRepository.update(monster);
    }

    public void delete(Monster monster) {
        monsterRepository.delete(monster);
    }

    public Monster findById(Integer id) {
        Monster monster = monsterRepository.findById(id);
        return monster;
    }

    public LiveData<List<Monster>> getAllMonsters() {
        return allMonsters;
    }
}