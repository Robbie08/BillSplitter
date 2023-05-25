package com.ortiz.billsplitter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.ortiz.billsplitter.Adapters.BillAdapter;
import com.ortiz.billsplitter.Adapters.ItemAdapter;
import com.ortiz.billsplitter.Listeners.SelectListener;
import com.ortiz.billsplitter.Listeners.SelectListenerImpl;
import com.ortiz.billsplitter.Models.Item;
import com.ortiz.billsplitter.Models.User;
import com.ortiz.billsplitter.Service.ItemService;
import com.ortiz.billsplitter.Service.ItemServiceImpl;

import java.util.LinkedList;
import java.util.List;

public class CreateBillActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;
    RecyclerView itemsRecyclerView;
    ItemService itemService;
    List<Item> items;
    SelectListener listener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_bill);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        listener = new SelectListenerImpl(this);
        items = new LinkedList<>();

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationBarCreateBillActivity);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        itemsRecyclerView = findViewById(R.id.rvCreateBillActivity);
        itemsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        itemService = new ItemServiceImpl(this, itemsRecyclerView);

        setRecyclerViewAdapter(itemsRecyclerView);
    }

    private void setRecyclerViewAdapter(RecyclerView recyclerView)
    {
        recyclerView.setAdapter(new ItemAdapter(getApplicationContext(), items, listener, itemService));
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
            case R.id.mItemAddBillItem:
                Log.i("OnNavigationItemReselected", "Add Bill got clicked");
                Intent createBillItemIntent = new Intent(getApplicationContext(), CreateItemActivity.class);
                startActivity(createBillItemIntent);
                return true;
            case R.id.mItemSettings:
                Log.i("OnNavigationItemReselected", "Settings got clicked");
                return true;
        }
        return false;
    }
}