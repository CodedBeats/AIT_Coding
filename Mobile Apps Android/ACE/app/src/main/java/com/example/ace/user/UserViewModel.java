package com.example.ace.user;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.ace.favourite.Favourite;
import com.example.ace.favourite.FavouriteRepository;
import com.google.firebase.auth.FirebaseUser;

import java.util.List;

public class UserViewModel extends ViewModel {

    private UserRepository userRepository;
    private MutableLiveData<User> userLiveData = new MutableLiveData<>();

    public UserViewModel() {
        userRepository = new UserRepository();
    }

    // get user
    public LiveData<User> getUser() {
        return userRepository.getUser();
    }

    // update user
    public void updateUserPassword(String newPassword, String oldPassword, UserRepository.UserOperationCallback callback) {
        userRepository.updateUserPassword(newPassword, oldPassword, callback);
    }

    // delete user {
    public void deleteUser(FirebaseUser user, UserRepository.UserOperationCallback callback) {
        userRepository.deleteUser(user, callback);
    }
}
