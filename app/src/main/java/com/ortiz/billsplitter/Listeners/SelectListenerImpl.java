package com.ortiz.billsplitter.Listeners;

import android.content.Context;
import android.widget.Toast;

import com.ortiz.billsplitter.Listeners.SelectListener;
import com.ortiz.billsplitter.Models.Bill;

public class SelectListenerImpl implements SelectListener {

    Context context;

    /**
     * Constructor that helps wire in the context into other
     * components of the application.
     * @param context the context of the caller.
     */
    public SelectListenerImpl(Context context)
    {
        this.context = context;
    }

    /**
     * @inheritDoc
     */
    @Override
    public void onItemClicked(Bill bill) {
        Toast.makeText(this.context, bill.getName(), Toast.LENGTH_SHORT).show();
        // When the item gets clicked, open a new Activity
    }
}
