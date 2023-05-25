package com.ortiz.billsplitter.Service;

import android.content.Context;
import android.util.Log;

import androidx.recyclerview.widget.RecyclerView;

import com.ortiz.billsplitter.Models.Bill;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class BillsServiceImpl implements BillsService, Serializable {

    Context context;
    RecyclerView recyclerView;

    /**
     * Default constructor
     */
    public BillsServiceImpl(){}

    /**
     * Constructor that helps wire in the context into other
     * components of the application.
     * @param context
     */
    public BillsServiceImpl(Context context)
    {
        this.context = context;
    }
    /**
     * Constructor that helps wire in the context and recycler view to
     * other components of the application.
     * @param context from the caller
     * @param recyclerView used by caller
     */
    public BillsServiceImpl(Context context, RecyclerView recyclerView)
    {
        this.context = context;
        this.recyclerView = recyclerView;
    }

    /**
     * @inheritDoc
     */
    public RecyclerView fetchRecyclerView()
    {
        return recyclerView;
    }

    /**
     * @inheritDoc
     */
    public Bill createBill(String name){
        return new Bill(name, new Date(System.currentTimeMillis()));
    }

    /**
     * @inheritDoc
     */
    public void insertBillIntoRecyclerView(Bill bill, List<Bill> bills)
    {
        if (bill == null)
        {
            Log.e("RecyclerView", "Failed to insert bill into recycler view because the Bill is null.");
            return;
        }

        Log.d("RecyclerView",
                String.format("Inserting bill '%s' into the recycler view.", bill.getName()));

        bills.add(0, bill);

        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (adapter == null)
        {
            Log.e("RecyclerView",
                    String.format("Failed to insert bill '%s' into the recycler view.", bill.getName()));
            return;
        }
        adapter.notifyItemInserted(0);
        Log.i("RecyclerView",
                String.format("Inserted bill '%s' into the recycler view.", bill.getName()));
    }
}
