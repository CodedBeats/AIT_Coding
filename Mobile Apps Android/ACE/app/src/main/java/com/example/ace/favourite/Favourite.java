package com.example.ace.favourite;

import androidx.annotation.NonNull;
import androidx.room.Ignore;

import java.io.Serializable;

public class Favourite implements Serializable {
    String userID, affirmationID;

    @Ignore
    public Favourite() {
    }

    public Favourite(String userID, String affirmationID) {
        this.userID = userID;
        this.affirmationID = affirmationID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getAffirmationID() {
        return affirmationID;
    }

    public void setAffirmationID(String affirmationID) {
        this.affirmationID = affirmationID;
    }

    @NonNull
    @Override
    public String toString() {
        return "Favourite{" +
                "userID='" + userID + '\'' +
                ", affirmationID='" + affirmationID + '\'' +
                '}';
    }
}
