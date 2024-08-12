package com.example.n8_locketapp.ui.history;

import android.view.LayoutInflater;
import android.view.View;

import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.n8_locketapp.adapter.PostAdapter;
import com.example.n8_locketapp.adapter.PostDetailAdapter;
import com.example.n8_locketapp.base.BaseFragment;
import com.example.n8_locketapp.databinding.FragmentHistoryBinding;

import java.util.ArrayList;
import java.util.Arrays;
import carbon.view.View;

public class HistoryFragment extends BaseFragment<FragmentHistoryBinding> {
    private PostAdapter postAdapter;
    private PostDetailAdapter postDetailAdapter;
    private HistoryViewModel historyViewModel;

    @Override
    public void initData() {
        postAdapter = new PostAdapter(this);
        postDetailAdapter = new PostDetailAdapter(this);
        historyViewModel = new ViewModelProvider(this).get(HistoryViewModel.class);
    }

    @Override
    public void initView() {
        getBinding().recyclerListPost.setLayoutManager(new GridLayoutManager(requireContext(), 3));
        getBinding().recyclerListPost.setAdapter(postAdapter);
        postAdapter.setListPosts(new ArrayList<>(
                Arrays.asList("A", "A", "A", "A", "A", "A", "A", "A", "A", "A", "A"))
        );

        getBinding().recyclerDetailPost.setLayoutManager(new LinearLayoutManager(requireContext()));
        getBinding().recyclerDetailPost.setAdapter(postDetailAdapter);
        postDetailAdapter.setListPosts(new ArrayList<>(
                Arrays.asList("A", "A", "A", "A", "A", "A", "A", "A", "A", "A", "A"))
        );
    }

    @Override
    public void initEvent() {
        historyViewModel.currentPos.observe(getViewLifecycleOwner(), position -> {
            getBinding().recyclerListPost.scrollToPosition(position);
            getBinding().recyclerDetailPost.scrollToPosition(position);
        });

        historyViewModel.status.observe(getViewLifecycleOwner(), status -> {
            if (status) {
                getBinding().recyclerListPost.setVisibility(View.VISIBLE);
                getBinding().recyclerDetailPost.setVisibility(View.GONE);
            }
            else {
                getBinding().recyclerListPost.setVisibility(View.GONE);
                getBinding().recyclerDetailPost.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    protected FragmentHistoryBinding inflateViewBinding(LayoutInflater inflater) {
        return FragmentHistoryBinding.inflate(inflater);
    }
}
