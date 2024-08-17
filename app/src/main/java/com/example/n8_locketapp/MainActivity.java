package com.example.n8_locketapp;

import android.Manifest;
import android.content.pm.PackageManager;
import android.view.LayoutInflater;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.cloudinary.android.MediaManager;


import java.util.HashMap;

import com.example.n8_locketapp.base.BaseActivity;
import com.example.n8_locketapp.databinding.ActivityMainBinding;

public class MainActivity extends BaseActivity<ActivityMainBinding> {

    @Override
    public void initData() {

    }

    @Override
    public void handleEvent() {
        permission();
        cloudinaryConfig();
    }

    @Override
    public void bindData() {

    }

    @Override
    protected ActivityMainBinding inflateViewBinding(LayoutInflater inflater) {
        return ActivityMainBinding.inflate(inflater);
    }

    private void permission() {
        boolean cameraPermission = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED;
        boolean storagePermission = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED;
        if (cameraPermission && storagePermission) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
        } else if (cameraPermission) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 1);
        } else if (storagePermission) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
        }
    }

    private void cloudinaryConfig() {
        HashMap<String, String> config = new HashMap<>();
        config.put("cloud_name", "dnhxdubzr");
        config.put("api_key", "327892482335459");
        config.put("api_secret", "9T0p5bURodBwCpW_k3s469OU5Bc");
        MediaManager.init(this, config);
    }
}