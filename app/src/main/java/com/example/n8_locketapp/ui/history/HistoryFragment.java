package com.example.n8_locketapp.ui.history;

import android.view.LayoutInflater;

import androidx.recyclerview.widget.GridLayoutManager;

import com.example.n8_locketapp.adapter.PostAdapter;
import com.example.n8_locketapp.base.BaseFragment;
import com.example.n8_locketapp.databinding.FragmentHistoryBinding;

import java.util.ArrayList;
import java.util.Arrays;

public class HistoryFragment extends BaseFragment<FragmentHistoryBinding> {
    private PostAdapter postAdapter = new PostAdapter();


    @Override
    public void initData() {

    }

    @Override
    public void initView() {
        getBinding().recyclerListPost.setLayoutManager(new GridLayoutManager(requireContext(), 3));
        getBinding().recyclerListPost.setAdapter(postAdapter);
        postAdapter.setListPosts(new ArrayList<>(
                Arrays.asList("A", "A", "A", "A", "A", "A", "A", "A", "A", "A", "A"))
        );
    }

    @Override
    public void initEvent() {

    }

    @Override
    protected FragmentHistoryBinding inflateViewBinding(LayoutInflater inflater) {
        return FragmentHistoryBinding.inflate(inflater);
    }
}
