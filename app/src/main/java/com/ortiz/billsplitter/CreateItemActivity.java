package com.ortiz.billsplitter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class CreateItemActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_item);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationBarCreateItemActivity);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
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