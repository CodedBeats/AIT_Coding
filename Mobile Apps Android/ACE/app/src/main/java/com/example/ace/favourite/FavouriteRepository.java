package com.example.ace.favourite;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.ace.affirmation.Affirmation;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;
import java.util.List;

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

    // add favourite from userID and affirmationID

}
