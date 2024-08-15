package com.example.n8_locketapp.ui.profile;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;

import com.cloudinary.android.MediaManager;
import com.cloudinary.android.callback.UploadCallback;
import com.cloudinary.android.callback.ErrorInfo;
import com.bumptech.glide.Glide;


import com.example.n8_locketapp.MyApplication;
import com.example.n8_locketapp.base.BaseFragment;
import com.example.n8_locketapp.databinding.DialogEditAvatarBinding;
import com.example.n8_locketapp.databinding.FragmentProfileBinding;
import com.example.n8_locketapp.model.User;
import com.example.n8_locketapp.repository.UserRepository;

import java.util.Map;

public class ProfileFragment extends BaseFragment<FragmentProfileBinding> {
    private User currentUser = MyApplication.getUser();

    private UserRepository userRepository = new UserRepository();

    private Dialog settingDialog;

    private DialogEditAvatarBinding dialogEditAvatarBinding;

    private ActivityResultLauncher<Intent> resultLauncher;
    @Override
    public void initData() {
        settingDialog = new Dialog(requireContext());
        dialogEditAvatarBinding = DialogEditAvatarBinding.inflate(getLayoutInflater());
        resultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
            Uri imageUri = result.getData().getData();
            if (result.getResultCode() == Activity.RESULT_OK) {
                MediaManager.get().upload(imageUri).callback(new UploadCallback() {
                    @Override
                    public void onStart(String requestId) {

                    }

                    @Override
                    public void onProgress(String requestId, long bytes, long totalBytes) {

                    }

                    @Override
                    public void onSuccess(String requestId, Map resultData) {
                        String avatarUrl = MediaManager.get().url().generate(resultData.get("public_id").toString());
                        User tempUser = new User();
                        tempUser.setUser(currentUser);
                        tempUser.setAvatar(avatarUrl);
                        userRepository.updateUser(tempUser, it -> {
                            currentUser.setUser(tempUser);
                            try {
                                Glide.with(getBinding().imgAvatar.getContext())
                                        .load(currentUser.getAvatar())
                                        .into(getBinding().imgAvatar);
                                Toast.makeText(getActivity(), "Change success!", Toast.LENGTH_LONG).show();
                            } catch (Exception ignored) {

                            }
                        });
                    }

                    @Override
                    public void onError(String requestId, ErrorInfo error) {

                    }

                    @Override
                    public void onReschedule(String requestId, ErrorInfo error) {

                    }
                }).dispatch();
            }
        });
    }

    @Override
    public void initView() {
        String fullName = currentUser.getFirstName() + " " + currentUser.getLastName();
        getBinding().txtUsername.setText(fullName);
        Glide.with(getBinding().imgAvatar.getContext())
                .load(currentUser.getAvatar())
                .into(getBinding().imgAvatar);
    }

    @Override
    public void initEvent() {

    }

    @Override
    protected FragmentProfileBinding inflateViewBinding(LayoutInflater inflater) {
        return FragmentProfileBinding.inflate(inflater);
    }
}
