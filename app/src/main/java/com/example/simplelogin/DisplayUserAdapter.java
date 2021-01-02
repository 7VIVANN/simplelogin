package com.example.simplelogin;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.example.simplelogin.model.User;

public class DisplayUserAdapter extends ListAdapter<User, DisplayUserViewHolder> {
    protected DisplayUserAdapter(@NonNull DiffUtil.ItemCallback<User> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public DisplayUserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return DisplayUserViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull DisplayUserViewHolder holder, int position) {
            User current = getItem(position);
            holder.bind(current.username, current.password, position);
    }

    public static class UserDiff extends DiffUtil.ItemCallback<User> {
        @Override
        public boolean areItemsTheSame(@NonNull User oldItem, @NonNull User newItem) {
            return oldItem.equals(newItem);
        }

        @Override
        public boolean areContentsTheSame(@NonNull User oldItem, @NonNull User newItem) {
            return oldItem.username.compareTo(newItem.username)==0;
        }
    }
}
