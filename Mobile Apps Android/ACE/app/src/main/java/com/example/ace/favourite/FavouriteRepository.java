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
                        Log.i("XYZ", "Error getting documents.", task.getException());
                    }
                });

        return favouritesLiveData;
    }

    public interface FavouriteOperationCallback {
        void onSuccess();
        void onFailure(Exception e);
    }

    public void addFavourite(String userID, String affirmationID, FavouriteOperationCallback callback) {
        // Check for duplicates
        db.collection("favourites")
            .whereEqualTo("userID", userID)
            .whereEqualTo("affirmationID", affirmationID)
            .get()
            .addOnCompleteListener(task -> {
                if (task.isSuccessful() && task.getResult() != null && task.getResult().isEmpty()) {
                    // No duplicates found, proceed to add new favourite
                    Map<String, Object> favouriteMap = new HashMap<>();
                    favouriteMap.put("userID", userID);
                    favouriteMap.put("affirmationID", affirmationID);

                    // Add a new document with an auto-generated ID
                    db.collection("favourites").add(favouriteMap)
                            .addOnSuccessListener(documentReference -> {
                                // Notify success
                                callback.onSuccess();
                            })
                            .addOnFailureListener(e -> {
                                // Notify failure
                                callback.onFailure(e);
                            });
                } else if (task.isSuccessful() && task.getResult() != null && !task.getResult().isEmpty()) {
                    // Duplicate exists, notify failure
                    callback.onFailure(new Exception("favourite already exists."));
                } else {
                    // Query failed, notify failure
                    callback.onFailure(task.getException());
                }
            });
    }


}
