package com.ortiz.billsplitter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.ortiz.billsplitter.Adapters.UserAdapter;
import com.ortiz.billsplitter.Listeners.SelectListener;
import com.ortiz.billsplitter.Listeners.SelectListenerImpl;
import com.ortiz.billsplitter.Models.User;
import com.ortiz.billsplitter.Service.ItemService;
import com.ortiz.billsplitter.Service.ItemServiceImpl;
import com.ortiz.billsplitter.Service.UserService;
import com.ortiz.billsplitter.Service.UserServiceImpl;

import java.util.LinkedList;
import java.util.List;

public class CreateItemActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;
    RecyclerView usersRecyclerView;
    List<User> users;
    UserService userService;
    SelectListener listener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_item);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        users = new LinkedList<>();
        users.add(new User("Johnson B."));
        listener = new SelectListenerImpl(this);
        userService = new UserServiceImpl(this);

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationBarCreateItemActivity);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        usersRecyclerView = findViewById(R.id.rvCreateItemActivityUsers);
        usersRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        setRecyclerViewAdapter(usersRecyclerView);

    }

    private void setRecyclerViewAdapter(RecyclerView recyclerView)
    {
        recyclerView.setAdapter(new UserAdapter(getApplicationContext(), users, listener, userService));
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Log.i("Clicked", "Listener activated!");
        switch (item.getItemId()){
            case R.id.mItemHome:
                Log.i("OnNavigationItemReselected", "Home got clicked");
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                return true;
            case R.id.mItemSearch:
                Log.i("OnNavigationItemReselected", "Search got clicked");
                return true;
            case R.id.mItemProfile:
                Log.i("OnNavigationItemReselected", "Profile got clicked");
                return true;
            case R.id.mItemAddUser:
                Log.i("OnNavigationItemReselected", "Add Item got clicked");
                // Call the dialog here

                return true;
            case R.id.mItemSettings:
                Log.i("OnNavigationItemReselected", "Settings got clicked");
                return true;
        }
        return false;
    }
}