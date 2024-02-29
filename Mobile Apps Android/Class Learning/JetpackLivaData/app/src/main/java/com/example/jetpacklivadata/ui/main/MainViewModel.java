package com.example.jetpacklivadata.ui.main;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends AndroidViewModel {
    public MainViewModel(@NonNull Application application) {
        super(application);
    }
    // TODO: Implement the ViewModel
    private MutableLiveData<String> total = new MutableLiveData<>();

    public MutableLiveData<String> getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total.setValue(total);
    }
}