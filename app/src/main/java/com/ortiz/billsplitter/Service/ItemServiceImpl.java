package com.ortiz.billsplitter.Service;

import android.content.Context;
import android.util.Log;

import androidx.recyclerview.widget.RecyclerView;

import com.ortiz.billsplitter.Models.Item;
import com.ortiz.billsplitter.Models.User;

import java.util.List;

public class ItemServiceImpl implements ItemService{

    Context context;
    RecyclerView recyclerView;
    public ItemServiceImpl(){}

    public ItemServiceImpl(Context context)
    {
        this.context = context;
    }

    public ItemServiceImpl(Context context, RecyclerView recyclerView)
    {
        this.context = context;
        this.recyclerView = recyclerView;
    }

    @Override
    public RecyclerView fetchRecyclerView()
    {
        return this.recyclerView;
    }

    @Override
    public Item createItem(String name, Double subTotal, List<User> users)
    {
        return new Item(name, subTotal, users);
    }

    @Override
    public void insertItemIntoRecyclerView(Item item, List<Item> items)
    {

        if (item == null)
        {
            Log.e("RecyclerView", "Failed to insert bill into recycler view because the Bill is null.");
            return;
        }

        Log.d("RecyclerView",
                String.format("Inserting item '%s' into the recycler view.", item.getName()));

        items.add(0, item);
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (adapter == null)
        {
            Log.e("RecyclerView",
                    String.format("Failed to insert item '%s' into the recycler view.", item.getName()));
            return;
        }
        adapter.notifyItemInserted(0);
        Log.i("RecyclerView",
                String.format("Inserted item '%s' into the recycler view.", item.getName()));
    }
}
