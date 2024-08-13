package com.example.n8_locketapp.ui.profile;

import android.view.LayoutInflater;
import android.widget.Toast;

import androidx.navigation.Navigation;

import com.example.n8_locketapp.MyApplication;
import com.example.n8_locketapp.base.BaseFragment;
import com.example.n8_locketapp.databinding.FragmentEditUsernameBinding;
import com.example.n8_locketapp.model.User;
import com.example.n8_locketapp.repository.UserRepository;

public class EditUsernameFragment extends BaseFragment<FragmentEditUsernameBinding> {
    private UserRepository userRepository = new UserRepository();

    private User currentUser = MyApplication.getUser();
    @Override
    public void initData() {

    }

    @Override
    public void initView() {

    }

    @Override
    public void initEvent() {
        getBinding().btnSave.setEnabled(false);
        getBinding().btnSave.setOnClickListener(view -> {
            User tempUser = new User();
            tempUser.setUser(currentUser);
            tempUser.setFirstName(String.valueOf(getBinding().edtFirstName.getText()));
            tempUser.setLastName(String.valueOf(getBinding().edtLastName.getText()));
            userRepository.updateUser(tempUser, it -> {
                currentUser.setUser(tempUser);
                Toast.makeText(requireContext(), "Change username success", Toast.LENGTH_LONG).show();
            });
        });

        getBinding().btnBack.setOnClickListener(view -> {
            Navigation.findNavController(getView()).popBackStack();
        });

        getBinding().edtFirstName.addTextChangedListener(textWatcher());

        getBinding().edtLastName.addTextChangedListener(textWatcher());
    }

    @Override
    protected FragmentEditUsernameBinding inflateViewBinding(LayoutInflater inflater) {
        return null;
    }
}
