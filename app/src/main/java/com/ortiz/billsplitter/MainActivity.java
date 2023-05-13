package com.ortiz.billsplitter;

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
    String recyclerViewName = "RV_BILLS";
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

        billsService = new BillsServiceImpl(this, billsRecyclerView);

        bills.add(billsService.createBill("RakiRaki", 85.62, 4.50, 12.00));
        bills.add(billsService.createBill("Javier's", 143.23, 12.66, 30.23));
        bills.add(billsService.createBill("Red O's", 125.27, 10.36, 25.26));
        bills.add(billsService.createBill("Papa Johns Pizza", 85.62, 4.50, 12.00));
        bills.add(billsService.createBill("Sammy's", 143.23, 12.66, 30.23));

        setRecyclerViewAdapter(billsRecyclerView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    private void displayCreateBillsDialog()
    {
        CreateBillDialog createBillDialog = new CreateBillDialog(bills, this, billsService);
        createBillDialog.show(getSupportFragmentManager(), "Create Bill Dialog");
    }


    private void setRecyclerViewAdapter(RecyclerView recyclerView)
    {
        recyclerView.setAdapter(new BillAdapter(getApplicationContext(), bills, listener));
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
                displayCreateBillsDialog(); // this dialog allows us to create bills
                return true;
            case R.id.mItemSettings:
                Log.i("OnNavigationItemReselected", "Settings got clicked");
                return true;
        }
        return false;
    }
}