package com.ortiz.billsplitter.Listeners;

import android.content.Context;
import android.widget.Toast;

import com.ortiz.billsplitter.Listeners.SelectListener;
import com.ortiz.billsplitter.Models.Bill;

public class SelectListenerImpl implements SelectListener {

    Context context;

    public SelectListenerImpl(Context context)
    {
        this.context = context;
    }

    @Override
    public void onItemClicked(Bill bill) {
        Toast.makeText(this.context, bill.getName(), Toast.LENGTH_SHORT).show();
        // When the item gets clicked, open a new Activity
    }
}
