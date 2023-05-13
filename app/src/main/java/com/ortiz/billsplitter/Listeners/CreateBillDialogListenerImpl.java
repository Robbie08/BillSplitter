package com.ortiz.billsplitter.Listeners;

import android.content.Context;
import android.util.Log;

import androidx.recyclerview.widget.RecyclerView;

import com.ortiz.billsplitter.MainActivity;
import com.ortiz.billsplitter.Models.Bill;

import java.util.Date;
import java.util.List;

public class CreateBillDialogListenerImpl implements CreateBillDialogListener{
    Context context;

    public CreateBillDialogListenerImpl(Context context) {
        this.context = context;
    }

    @Override
    public void applyText(String billName, RecyclerView billsRecyclerView, List<Bill> bills) {
        Bill bill = new Bill(billName, new Date(System.currentTimeMillis()));
        Log.i("ApplyText", "Inserting bill into recycler view.");

        if (bill == null)
        {
            Log.i("ApplyText", "Failed to insert bill into recycler view because the Bill is null.");
            return;
        }

        bills.add(0, bill);

        RecyclerView.Adapter adapter = billsRecyclerView.getAdapter();
        if (adapter == null)
        {
            Log.i("ApplyText", "Failed to insert bill into recycler view because the adapter is null.");
            return;
        }
        adapter.notifyItemInserted(0);
        Log.i("ApplyText", "Inserted bill into recycler view.");
    }
}
