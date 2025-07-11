package com.example.ace.favourite;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.ace.affirmation.Affirmation;

import java.util.List;

public class FavouriteViewModel extends ViewModel {

    private FavouriteRepository favouriteRepository;
    private MutableLiveData<List<Favourite>> favouritesLiveData = new MutableLiveData<>();


    public FavouriteViewModel() {
        favouriteRepository = new FavouriteRepository();
    }

    // get all favourites from userID
    public LiveData<List<Favourite>> getFavouritesByUserID(String userID) {
        return favouriteRepository.getFavouritesByUserID(userID);
    }

    // add favourite
    public void addFavourite(String userID, String affirmationID, FavouriteRepository.FavouriteOperationCallback callback) {
        favouriteRepository.addFavourite(userID, affirmationID, callback);
    }

    // remove all of a user's favourites
    public void removeAllUserFavourites(String userID, FavouriteRepository.FavouriteOperationCallback callback) {
        favouriteRepository.removeAllUserFavourites(userID, callback);
    }

    // remove favourite
    public void removeFavourite(String userID, String affirmationID, FavouriteRepository.FavouriteOperationCallback callback) {
        favouriteRepository.removeFavourite(userID, affirmationID, callback);
    }

}
