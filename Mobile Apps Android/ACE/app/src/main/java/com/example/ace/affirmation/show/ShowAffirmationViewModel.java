package com.example.ace.affirmation.show;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.ace.affirmation.Affirmation;
import com.example.ace.affirmation.AffirmationRepository;

import java.util.Collections;
import java.util.List;

public class ShowAffirmationViewModel extends ViewModel {

    private AffirmationRepository affirmationRepository;
    private MutableLiveData<List<Affirmation>> affirmationsLiveData = new MutableLiveData<>();
    private MutableLiveData<Affirmation> randomAffirmation = new MutableLiveData<>();

    public ShowAffirmationViewModel() {
        affirmationRepository = new AffirmationRepository();

        // init LiveData with empty data
        affirmationsLiveData.setValue(Collections.emptyList());
        randomAffirmation.setValue(null);

        // Fetch affirmations from db
        fetchAffirmations();
    }

    private void fetchAffirmations() {
        affirmationRepository.getAllAffirmationsLiveData().observeForever(affirmations -> {
            affirmationsLiveData.setValue(affirmations); // Update LiveData
            // Now that affirmations are available, set a random affirmation
            randomAffirmation.setValue(affirmationRepository.getRandomAffirmation(affirmations));
        });
    }

    public LiveData<List<Affirmation>> getAllAffirmations() {
        return affirmationsLiveData;
    }

    public LiveData<Affirmation> getRandomAffirmation() {
        return randomAffirmation;
    }
}