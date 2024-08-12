package com.example.n8_locketapp.repository;

import com.google.android.gms.tasks.Task;

@FunctionalInterface
public interface UserOnComplete {
    void onComplete(Task it);
}
