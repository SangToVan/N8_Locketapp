package com.example.n8_locketapp.repository;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestoreException;

@FunctionalInterface
public interface NewsfeedSnapshotListener {
    void onSnapshot(DocumentSnapshot doc, FirebaseFirestoreException exception);
}
