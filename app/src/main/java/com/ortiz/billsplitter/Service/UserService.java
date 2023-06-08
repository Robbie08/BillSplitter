package com.ortiz.billsplitter.Service;

import androidx.recyclerview.widget.RecyclerView;

import com.ortiz.billsplitter.Models.User;

public interface UserService
{
    RecyclerView fetchRecyclerView();

    User createUser();

    void insertUserIntoRecyclerView();
}
