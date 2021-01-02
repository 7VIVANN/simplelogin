package com.example.simplelogin;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

public class DisplayUserViewHolder extends RecyclerView.ViewHolder {
    TextView username;
    TextView password;
    Button dummy;

    public DisplayUserViewHolder(@NonNull View itemView) {
        super(itemView);
        username = itemView.findViewById(R.id.username);
        password = itemView.findViewById(R.id.password);
        dummy = itemView.findViewById(R.id.dummy);
    }

    public void bind(String username, String password, int number)
    {
        this.username.setText(username);
        this.password.setText(password);
        this.dummy.setText(Integer.toString(number));
    }

    static DisplayUserViewHolder create(ViewGroup parent)
    {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_view_item, null, false);

        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        itemView.setLayoutParams(lp);

        return new DisplayUserViewHolder(itemView);
    }


}
