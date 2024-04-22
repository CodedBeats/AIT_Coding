package com.example.ace.user;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.ace.affirmation.Affirmation;
import com.example.ace.favourite.Favourite;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;

public class UserRepository {

    private FirebaseFirestore db;

    // Get the current Firebase user
    private FirebaseUser currentUser;
    private MutableLiveData<User> userLiveData = new MutableLiveData<>();

    public UserRepository() {
        db = FirebaseFirestore.getInstance();
    }

    // get user
    public LiveData<User> getUser() {
        MutableLiveData<User> liveDataUser = new MutableLiveData<>();
        currentUser = FirebaseAuth.getInstance().getCurrentUser();
        if (currentUser != null) {

            String uid = currentUser.getUid(); // Get the user's unique ID (UID)
            String email = currentUser.getEmail();

            User user = new User(uid, email);
            liveDataUser.setValue(user);
        }
        return liveDataUser;
    }

    // update user


    // interface for callback to improve feedback on void functions
    public interface UserOperationCallback {
        void onSuccess();
        void onFailure(Exception e);
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
        }
    }

}
