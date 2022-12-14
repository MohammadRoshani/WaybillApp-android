package com.waybill.waybillapp.view;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.waybill.waybillapp.R;
import com.waybill.waybillapp.adapter.MessageAdapter;
import com.waybill.waybillapp.databinding.FragmentMessageListBinding;
import com.waybill.waybillapp.viewmodel.MainActivityViewModel;

import java.util.Objects;

public class MessageListFragment extends Fragment {

    private MainActivityViewModel mainActivityViewModel;
    private FragmentMessageListBinding fragmentMessageListBinding;
    private MessageAdapter messageAdapter;

    public MessageListFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentMessageListBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_message_list, container, false);
        return fragmentMessageListBinding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mainActivityViewModel = ViewModelProviders.of(Objects.requireNonNull(getActivity())).get(MainActivityViewModel.class);
        messageAdapter = new MessageAdapter();

        mainActivityViewModel.getAllMessages().observe(this, messages -> {
            messageAdapter.submitList(messages);
        });

        fragmentMessageListBinding.setViewmodel(mainActivityViewModel);

        RecyclerView messagesRecyclerView =fragmentMessageListBinding.messagesListView;

        messagesRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        messagesRecyclerView.setHasFixedSize(true);
        messagesRecyclerView.setAdapter(messageAdapter);

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                    mainActivityViewModel.deleteMessage(messageAdapter.getCurrentItem(viewHolder.getAdapterPosition()));
            }
        }).attachToRecyclerView(messagesRecyclerView);

    }
}
