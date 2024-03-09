package com.example.jetpackpersistence;


import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Insert;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.jetpackpersistence.monster.Monster;
import com.example.jetpackpersistence.monster.MonsterDAO;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Monster.class}, version = 1, exportSchema = false)
public abstract class PersistenceRoomDatabase extends RoomDatabase {

    // declare all DAOs
    public abstract MonsterDAO monsterDAO();


    private static volatile PersistenceRoomDatabase INSTANCE;

    private static final int NUMBER_OF_THREADS = 4;

    public static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static PersistenceRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (PersistenceRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room
                            .databaseBuilder(context.getApplicationContext(), PersistenceRoomDatabase.class, "monster_db")
                            .addCallback(roomCallback)
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    public static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            populateInitialData(INSTANCE);
        }

        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            Log.i("XYZ", "Open DB called");
        }
    };

    private static void populateInitialData(PersistenceRoomDatabase instance) {
        PersistenceRoomDatabase.databaseWriteExecutor.execute(() -> {
            MonsterDAO monsterDAO = INSTANCE.monsterDAO();
            monsterDAO.insert(new Monster("Luca", "I am beautiful", "", 1, 5, 5));
            monsterDAO.insert(new Monster("Finn", "ACTINGGGG", "", 5, 4, 4));
            monsterDAO.insert(new Monster("Death", "I Am Become....something", "", 5, 1, 5));
        });
    }

}
