package com.example.ace.affirmation;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.example.ace.favourite.Favourite;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class AffirmationRepository {
    private Affirmation affirmation;
    private FirebaseFirestore db;
    private MutableLiveData<List<Affirmation>> affirmationsLiveData = new MutableLiveData<>();


    public AffirmationRepository() {
        db = FirebaseFirestore.getInstance();

        // get all affirmations
        db.collection("affirmations")
            .get()
            .addOnCompleteListener(task -> {
                if (task.isSuccessful()) {
                    List<Affirmation> affirmations = new ArrayList<>();
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        String id = document.getId();
                        String text = document.getString("text");
                        Object tagsObject = document.get("tags");
                        List<String> tags = (List<String>) tagsObject;

                        Affirmation affirmation = new Affirmation(id, text, tags);
                        affirmations.add(affirmation);
                    }
                    affirmationsLiveData.setValue(affirmations); // Update LiveData
                } else {
                    Log.i("XYZ", "Error getting documents.", task.getException());
                }
            });
    }

    public LiveData<List<Affirmation>> getAllAffirmationsLiveData() {
        return affirmationsLiveData;
    }

    // get random affirmation
    public Affirmation getRandomAffirmation(List<Affirmation> allAffirmations) {
        // get random index
        int randomIndex = new Random().nextInt(allAffirmations.size());

        // get the affirmation at random index
        return allAffirmations.get(randomIndex);
    }

    // get affirmation by ID
    public LiveData<Affirmation> getAffirmationByID(String affirmationID) {
        MutableLiveData<Affirmation> liveDataAffirmation = new MutableLiveData<>();

        db.collection("affirmations")
            .document(affirmationID)
            .get()
            .addOnCompleteListener(task -> {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document != null && document.exists()) {
                        String id = document.getId();
                        String text = document.getString("text");
                        Object tagsObject = document.get("tags");
                        List<String> tags = (List<String>) tagsObject;

                        Affirmation affirmation = new Affirmation(id, text, tags);
                        liveDataAffirmation.setValue(affirmation); // Update the LiveData object
                    } else {
                        Log.i("XYZ", "No such document.");
                    }
                } else {
                    Log.i("XYZ", "Error getting documents.", task.getException());
                }
            });

        return liveDataAffirmation;
    }
}
