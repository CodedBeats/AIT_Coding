package com.example.jetpackpersistence;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.jetpackpersistence.monster.Monster;
import com.example.jetpackpersistence.monster.MonsterDAO;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class MonsterRepository {

    private PersistenceRoomDatabase db;
    private MonsterDAO monsterDAO;

    private Monster monster;
    private LiveData<List<Monster>> allMonsters;

    public MonsterRepository(Application application) {
        db = PersistenceRoomDatabase.getDatabase(application);
        monsterDAO = db.monsterDAO();
        allMonsters = monsterDAO.findAll();
    }

    public void insert(Monster monster) {
        PersistenceRoomDatabase.databaseWriteExecutor.execute(() -> {
            monsterDAO.insert(monster);
        });
    }

    public void update(Monster monster) {
        PersistenceRoomDatabase.databaseWriteExecutor.execute(() -> {
            monsterDAO.update(monster);
        });
    }

    public void delete(Monster monster) {
        PersistenceRoomDatabase.databaseWriteExecutor.execute(() -> {
            monsterDAO.delete(monster);
        });
    }

    public LiveData<List<Monster>> getAllMonsters() {
        return allMonsters;
    }

    public Monster findById(int id) {
        Callable c = () -> {
            Monster monster = monsterDAO.findById(id);
            return monster;
        };

        Future<Monster> future = PersistenceRoomDatabase.databaseWriteExecutor.submit(c);
        try {
            monster = future.get();
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return monster;
    }
}
