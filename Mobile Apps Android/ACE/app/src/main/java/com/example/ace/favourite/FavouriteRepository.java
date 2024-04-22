package com.example.ace.favourite;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.ace.affirmation.Affirmation;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FavouriteRepository {

    private Favourite favourite;
    private FirebaseFirestore db;
    private MutableLiveData<List<Favourite>> favouritesLiveData = new MutableLiveData<>();

    public FavouriteRepository() {
        db = FirebaseFirestore.getInstance();
    }

    // get all favourites from userID
    public LiveData<List<Favourite>> getFavouritesByUserID(String userID) {
        db.collection("favourites")
                .whereEqualTo("userID", userID)
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        List<Favourite> favourites = new ArrayList<>();
                        for (QueryDocumentSnapshot document : task.getResult()) {
                            String affirmationID = document.getString("affirmationID");

                            Favourite favourite = new Favourite(userID, affirmationID);
                            favourites.add(favourite);
                        }
                        favouritesLiveData.setValue(favourites); // Update LiveData
                    } else {
                        Log.i("XYZ", "error getting documents", task.getException());
                    }
                });

        return favouritesLiveData;
    }

    // interface for callback to improve feedback on void functions
    public interface FavouriteOperationCallback {
        void onSuccess();
        void onFailure(Exception e);
    }

    // add favourite but only if it doesn't alredy exist
    public void addFavourite(String userID, String affirmationID, FavouriteOperationCallback callback) {
        // check for duplicates
        db.collection("favourites")
            .whereEqualTo("userID", userID)
            .whereEqualTo("affirmationID", affirmationID)
            .get()
            .addOnCompleteListener(task -> {
                if (task.isSuccessful() && task.getResult() != null && task.getResult().isEmpty()) {
                    // no duplicates found, add new favourite
                    Map<String, Object> favouriteMap = new HashMap<>();
                    favouriteMap.put("userID", userID);
                    favouriteMap.put("affirmationID", affirmationID);

                    // add favourite
                    db.collection("favourites").add(favouriteMap)
                            .addOnSuccessListener(documentReference -> {
                                // notify success
                                callback.onSuccess();
                            })
                            .addOnFailureListener(e -> {
                                // notify failure
                                callback.onFailure(e);
                            });
                } else if (task.isSuccessful() && task.getResult() != null && !task.getResult().isEmpty()) {
                    // duplicate exists, notify failure
                    callback.onFailure(new Exception("favourite already exists"));
                } else {
                    // query failed, notify failure
                    callback.onFailure(task.getException());
                }
            });
    }

    // remove favourite
    public void removeFavourite(String userID, String affirmationID, FavouriteOperationCallback callback) {
        // query for existing favorite
        db.collection("favourites")
            .whereEqualTo("userID", userID)
            .whereEqualTo("affirmationID", affirmationID)
            .get()
            .addOnCompleteListener(task -> {
                if (task.isSuccessful() && task.getResult() != null) {
                    if (!task.getResult().isEmpty()) {
                        // favorite exists -> delete
                        String documentId = task.getResult().getDocuments().get(0).getId();
                        db.collection("favourites").document(documentId)
                                .delete()
                                .addOnSuccessListener(aVoid -> {
                                    // notify success
                                    callback.onSuccess();
                                })
                                .addOnFailureListener(e -> {
                                    // notify failure
                                    callback.onFailure(e);
                                });
                    } else {
                        // no favorite found
                        callback.onFailure(new Exception("favorite not found"));
                    }
                } else {
                    // query failed
                    callback.onFailure(task.getException());
                }
            });
    }
}
