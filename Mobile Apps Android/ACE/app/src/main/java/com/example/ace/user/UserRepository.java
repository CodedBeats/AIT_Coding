package com.example.ace.user;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.ace.affirmation.Affirmation;
import com.example.ace.favourite.Favourite;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRepository {

    private FirebaseFirestore db;

    // Get the current Firebase user
    private FirebaseUser currentUser;
    private MutableLiveData<User> userLiveData = new MutableLiveData<>();

    public UserRepository() {
        db = FirebaseFirestore.getInstance();
    }


    // create user doc in userSeenAffirmations
    public void setupUserForSeenAffirmations(String userID) {
        Map<String, Object> userDoc = new HashMap<>();
        userDoc.put("userID", userID);
        userDoc.put("affirmationsSeen", new ArrayList<>());

        db.collection("userSeenAffirmations")
            .add(userDoc)
            .addOnSuccessListener(documentReference -> {
                // document added successfully
                Log.i("firebase-user", "User doc added, ID: " + documentReference.getId());
            })
            .addOnFailureListener(e -> {
                // failed to add document
                Log.e("firebase-user", "Error adding user document: " + e.getMessage());
            });
    }

    // delete user doc in userSeenAffirmations
    private void removeUserFromSeenAffirmations(String userID) {
        db.collection("userSeenAffirmations")
            .whereEqualTo("userID", userID)
            .get()
            .addOnCompleteListener(task -> {
                if (task.isSuccessful() && task.getResult() != null) {
                    if (!task.getResult().isEmpty()) {
                        // doc exists -> delete
                        String documentId = task.getResult().getDocuments().get(0).getId();
                        db.collection("userSeenAffirmations").document(documentId)
                            .delete()
                            .addOnSuccessListener(aVoid -> {
                                // success
                                Log.i("firebase-user", "successfully deleted user doc from coll");
                            })
                            .addOnFailureListener(e -> {
                                // failure
                                Log.i("firebase-user", "Error deleting user doc: " + e.getMessage());
                            });
                    } else {
                        // no doc found
                        Log.i("firebase-user", "no doc found");
                    }
                } else {
                    // query failed
                    Log.i("firebase-user", "query failed");
                }
            });
    }


    // get user
    public LiveData<User> getUser() {
        MutableLiveData<User> userLiveData = new MutableLiveData<>();
        currentUser = FirebaseAuth.getInstance().getCurrentUser();
        if (currentUser != null) {

            String uid = currentUser.getUid(); // Get the user's unique ID (UID)
            String email = currentUser.getEmail();

            User user = new User(uid, email);
            userLiveData.setValue(user);
        }
        return userLiveData;
    }


    // interface for callback to improve feedback on void functions
    public interface UserOperationCallback {
        void onSuccess();
        void onFailure(Exception e);
    }


    // update user
    public void updateUserPassword(String newPassword, String oldPassword, UserOperationCallback callback) {
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();

        if (currentUser != null) {
            // Re-authenticate the user (using their existing credentials)
            AuthCredential credential = EmailAuthProvider.getCredential(currentUser.getEmail(), oldPassword); // Replace with the actual user's password

            currentUser.reauthenticate(credential)
                    .addOnSuccessListener(authResult -> {
                        // User re-authenticated successfully
                        // Now update the password
                        currentUser.updatePassword(newPassword)
                                .addOnSuccessListener(aVoid -> {
                                    // Password updated successfully
                                    callback.onSuccess();
                                })
                                .addOnFailureListener(e -> {
                                    // Failed to update password
                                    callback.onFailure(e);
                                });
                    })
                    .addOnFailureListener(e -> {
                        // Re-authentication failed
                        callback.onFailure(e);
                    });
        } else {
            // User is not authenticated (not signed in)
            // Handle this case as needed (e.g., show a login screen)
            callback.onFailure(new Exception("User not authenticated."));
        }
    }


    // delete user
    public void deleteUser(FirebaseUser user, UserOperationCallback callback) {
        if (user != null) {
            // delete user
            user.delete()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        // notify success
                        callback.onSuccess();
                    } else {
                        Exception e = task.getException();
                        // notify failure
                        callback.onFailure(e);
                    }
                });

            // remove user from userSeenAffirmations
            removeUserFromSeenAffirmations(user.getUid());
        }
    }

}
