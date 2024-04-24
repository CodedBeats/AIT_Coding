package com.example.ace.affirmation;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import com.example.ace.favourite.Favourite;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
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
    }

    // set all affirmations that the user hasn't seen
    public void getUnseenAffirmationsForUser(String userID) {
        // get user's document from the userSeenAffirmations coll
        db.collection("userSeenAffirmations")
            .whereEqualTo("userID", userID)
            .limit(1)
            .get()
            .addOnCompleteListener(task -> {
                if (task.isSuccessful()) {
                    List<Affirmation> unseenAffirmations = new ArrayList<>();
                    for (QueryDocumentSnapshot userDoc : task.getResult()) {
                        // retrieve the "affirmationsSeen" arr from doc
                        List<String> seenAffirmationIDs = (List<String>) userDoc.get("affirmationsSeen");
                        Log.i("firebase-affirmation", "Seen affirmationIDs: "+ Arrays.toString(seenAffirmationIDs.toArray()));

                        // query all affirmations
                        db.collection("affirmations")
                            .get()
                            .addOnCompleteListener(affirmationsTask -> {
                                if (affirmationsTask.isSuccessful()) {
                                    for (QueryDocumentSnapshot affirmationDoc : affirmationsTask.getResult()) {
                                        String affirmationID = affirmationDoc.getId();
                                        String text = affirmationDoc.getString("text");
                                        Object tagsObject = affirmationDoc.get("tags");
                                        List<String> tags = (List<String>) tagsObject;

                                        // check if affirmationID is not in seen list
                                        if (!seenAffirmationIDs.contains(affirmationID)) {
                                            Affirmation affirmation = new Affirmation(affirmationID, text, tags);
                                            unseenAffirmations.add(affirmation);
                                        }
                                    }
                                    affirmationsLiveData.setValue(unseenAffirmations); // Update LiveData
                                } else {
                                    Log.i("firebase-affirmation", "Error getting affirmations.", affirmationsTask.getException());
                                }
                            });
                    }
                } else {
                    Log.i("firebase-affirmation", "Error getting user documents.", task.getException());
                }
            });
    }


    // get all affirmations that the user hasn't seen
    public LiveData<List<Affirmation>> getAllAffirmationsLiveData(String userID) {
        getUnseenAffirmationsForUser(userID);
        return affirmationsLiveData;
    }


    // add affirmation as seen
    private void addAffirmationAsSeen(String userID, String affirmationID) {
        // get user's document from the userSeenAffirmations coll
        db.collection("userSeenAffirmations")
            .whereEqualTo("userID", userID)
            .limit(1)
            .get()
            .addOnCompleteListener(task -> {
                if (task.isSuccessful()) {
                    List<String> seenAffirmationIDs = new ArrayList<>();
                    for (QueryDocumentSnapshot userDoc : task.getResult()) {
                        // retrieve  existing "affirmationsSeen" array
                        seenAffirmationIDs = (List<String>) userDoc.get("affirmationsSeen");

                        // add new affirmationID to arr
                        seenAffirmationIDs.add(affirmationID);

                        // update user document
                        db.collection("userSeenAffirmations")
                            .document(userDoc.getId())
                            .update("affirmationsSeen", seenAffirmationIDs)
                            .addOnSuccessListener(aVoid -> {
                                // affirmation added successfully
                                Log.i("firebase-affirmation", "Affirmation added to seen list");
                            })
                            .addOnFailureListener(e -> {
                                // failed to add affirmation
                                Log.e("firebase-affirmation", "Error adding affirmation: " + e.getMessage());
                            });
                    }
                } else {
                    Log.i("firebase-affirmation", "Error getting user document.", task.getException());
                }
            });
    }


    // get random affirmation
    public Affirmation getRandomAffirmation(String userID, List<Affirmation> allAffirmations) {
        // handle if all affirmations have been seen
        if (allAffirmations.isEmpty()) {
            // return a default affirmation (you can customize the text and tags)
            return new Affirmation("default_id", "You are amazing!", Collections.singletonList("no more sorry :("));
        }

        // get random index
        int randomIndex = new Random().nextInt(allAffirmations.size());

        // add randomly selected affirmation as seen to userSeenAffirmations
        String affirmationID = allAffirmations.get(randomIndex).getId();
        addAffirmationAsSeen(userID, affirmationID);

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
                        Log.i("firebase-affirmation", "No such document.");
                    }
                } else {
                    Log.i("firebase-affirmation", "Error getting documents.", task.getException());
                }
            });

        return liveDataAffirmation;
    }
}
