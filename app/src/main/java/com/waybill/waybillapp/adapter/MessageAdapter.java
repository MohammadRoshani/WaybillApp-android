package com.waybill.waybillapp.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.waybill.waybillapp.R;
import com.waybill.waybillapp.databinding.MessageItemBinding;
import com.waybill.waybillapp.model.Message;

public class MessageAdapter extends ListAdapter<Message, MessageAdapter.MessageHolder> {

    public MessageAdapter() {
        super(new DiffUtil.ItemCallback<Message>() {
            @Override
            public boolean areItemsTheSame(@NonNull Message oldItem, @NonNull Message newItem) {
                return oldItem.getId() == newItem.getId();
            }

            @Override
            public boolean areContentsTheSame(@NonNull Message oldItem, @NonNull Message newItem) {
                return oldItem.equals(newItem);
            }
        });
    }

    @NonNull
    @Override
    public MessageHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MessageHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.message_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MessageHolder holder, int position) {
        holder.bind(getItem(position));
    }

    public Message getCurrentItem(int position) {
        return getItem(position);
    }

    static class MessageHolder extends RecyclerView.ViewHolder {


        private final MessageItemBinding messageItemBinding;

        private MessageHolder(MessageItemBinding messageItemBinding) {
            super(messageItemBinding.getRoot());
            this.messageItemBinding = messageItemBinding;
        }

        private void bind(Message message) {
            messageItemBinding.setMessage(message);
            messageItemBinding.executePendingBindings();
        }
    }
}
