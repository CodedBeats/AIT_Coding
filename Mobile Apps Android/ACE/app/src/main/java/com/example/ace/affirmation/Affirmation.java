package com.example.ace.affirmation;

import androidx.annotation.NonNull;
import androidx.room.Ignore;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class Affirmation implements Serializable {

    String id, text;
    List<String> tags;


    @Ignore
    public Affirmation() {
    }

    public Affirmation(String id, String text, List<String> tags) {
        this.id = id;
        this.text = text;
        this.tags = tags;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }


    @NonNull
    @Override
    public String toString() {
        return "Affirmation{" +
                "id='" + id + '\'' +
                ", text='" + text + '\'' +
                ", tags=" + tags +
                '}';
    }
}
