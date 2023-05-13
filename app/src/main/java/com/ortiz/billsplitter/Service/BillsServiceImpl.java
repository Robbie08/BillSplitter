package com.ortiz.billsplitter.Service;

import android.content.Context;
import android.util.Log;

import androidx.recyclerview.widget.RecyclerView;

import com.ortiz.billsplitter.Models.Bill;
import com.ortiz.billsplitter.Models.Item;
import com.ortiz.billsplitter.Models.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class BillsServiceImpl implements BillsService{

    Context context;
    RecyclerView recyclerView;

    public BillsServiceImpl(Context context, RecyclerView recyclerView)
    {
        this.context = context;
        this.recyclerView = recyclerView;
    }

    public Bill createBill(String name, Double subtotal, Double tax, Double tip){
        List<Item> allItems = new ArrayList<>();

        User user1 = new User("Jon");
        User user2 = new User("Vlad");
        User user3 = new User("Bob");
        allItems.add(new Item("Pizza", 16.99, new ArrayList<>(Arrays.asList(user1, user2, user3))));
        allItems.add(new Item("Duck IPA", 9.99, new ArrayList<>(Arrays.asList(user1))));
        allItems.add(new Item("Pepsi", 4.99, new ArrayList<>(Arrays.asList(user2))));
        allItems.add(new Item("Poppers (buffalo)", 12.99, new ArrayList<>(Arrays.asList(user3, user2))));
        allItems.add(new Item("Back Alley Pale Ale", 11.99, new ArrayList<>(Arrays.asList(user3))));
        return new Bill(name, allItems, subtotal, tax, subtotal+tax,tip, new Date(System.currentTimeMillis()));
    }


    public void insertBillIntoRecyclerView(Bill bill, List<Bill> bills)
    {
        String recyclerViewName = String.format("RecyclerView - Bill(%s)", bill.getName());
        Log.i(recyclerViewName, "Inserting bill into recycler view.");

        if (bill == null)
        {
            Log.i(recyclerViewName, "Failed to insert bill into recycler view because the Bill is null.");
            return;
        }

        bills.add(0, bill);

        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (adapter == null)
        {
            Log.i(recyclerViewName, "Failed to insert bill into recycler view because the adapter is null.");
            return;
        }
        adapter.notifyItemInserted(0);
        Log.i(recyclerViewName, "Inserted bill into recycler view.");
    }
}
