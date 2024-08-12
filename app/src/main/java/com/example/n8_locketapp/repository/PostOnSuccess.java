package com.example.n8_locketapp.repository;

import com.google.firebase.firestore.QuerySnapshot;

@FunctionalInterface
public interface PostOnSuccess {
    void onSuccess(QuerySnapshot doc);
}
