package com.example.n8_locketapp.repository;

import com.google.firebase.firestore.DocumentSnapshot;

@FunctionalInterface
public interface UserOnSuccess {
    void onSuccess(DocumentSnapshot doc);
}
