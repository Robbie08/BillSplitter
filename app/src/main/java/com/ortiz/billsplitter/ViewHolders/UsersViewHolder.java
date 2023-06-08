package com.ortiz.billsplitter.ViewHolders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ortiz.billsplitter.R;

public class UsersViewHolder extends RecyclerView.ViewHolder {

    public TextView tvUsersUserName;
    public UsersViewHolder(@NonNull View itemView) {
        super(itemView);
        tvUsersUserName = (TextView) itemView.findViewById(R.id.tvUsersUserName);
    }
}
