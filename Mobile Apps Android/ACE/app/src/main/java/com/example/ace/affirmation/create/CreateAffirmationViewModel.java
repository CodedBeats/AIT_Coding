package com.example.ace.affirmation.create;

import androidx.lifecycle.ViewModel;

import com.example.ace.affirmation.AffirmationRepository;

public class CreateAffirmationViewModel extends ViewModel {

    AffirmationRepository affirmationRepository;

    public CreateAffirmationViewModel() {
        affirmationRepository = new AffirmationRepository();
    }

    public void createAffirmation(String inputText, String inputTag1, String inputTag2, AffirmationRepository.AffirmationOperationCallback callback) {
        affirmationRepository.createAffirmation(inputText, inputTag1, inputTag2, callback);
    }
}
