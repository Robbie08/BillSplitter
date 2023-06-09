package com.ortiz.billsplitter;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ortiz.billsplitter.Adapters.BillAdapter;
import com.ortiz.billsplitter.Listeners.SelectListener;
import com.ortiz.billsplitter.Listeners.SelectListenerImpl;
import com.ortiz.billsplitter.Models.Bill;
import com.ortiz.billsplitter.Service.BillsService;
import com.ortiz.billsplitter.Service.BillsServiceImpl;
import com.ortiz.billsplitter.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    private ActivityMainBinding binding;

    RecyclerView billsRecyclerView;
    BottomNavigationView bottomNavigationView;
    List<Bill> bills;
    SelectListener listener;
    BillsService billsService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        listener = new SelectListenerImpl(this);
        bills = new LinkedList<>();

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationBar);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        billsRecyclerView = findViewById(R.id.recyclerViewBills);
        billsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Helps Autowire the recycler view and context into fragments
        billsService = new BillsServiceImpl(this, billsRecyclerView);

        bills.add(billsService.createBill("RakiRaki"));
        bills.add(billsService.createBill("Javier's"));
        bills.add(billsService.createBill("Red O's"));
        bills.add(billsService.createBill("Papa Johns Pizza"));
        bills.add(billsService.createBill("Sammy's"));

        setRecyclerViewAdapter(billsRecyclerView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    private void setRecyclerViewAdapter(RecyclerView recyclerView)
    {
        recyclerView.setAdapter(new BillAdapter(getApplicationContext(), bills, listener, billsService));
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Log.i("Clicked", "Listener activated!");
        switch (item.getItemId()){
            case R.id.mItemHome:
                Log.i("OnNavigationItemReselected", "Home got clicked");
                return true;
            case R.id.mItemSearch:
                Log.i("OnNavigationItemReselected", "Search got clicked");
                return true;
            case R.id.mItemProfile:
                Log.i("OnNavigationItemReselected", "Profile got clicked");
                return true;
            case R.id.mItemAddBill:
                Log.i("OnNavigationItemReselected", "Add Bill got clicked");
                Intent intent = new Intent(getApplicationContext(), CreateBillActivity.class);
                startActivity(intent);
                return true;
            case R.id.mItemSettings:
                Log.i("OnNavigationItemReselected", "Settings got clicked");
                return true;
        }
        return false;
    }
}