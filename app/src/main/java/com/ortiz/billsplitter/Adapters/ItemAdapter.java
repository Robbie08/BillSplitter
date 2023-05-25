package com.ortiz.billsplitter.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ortiz.billsplitter.Listeners.SelectListener;
import com.ortiz.billsplitter.Models.Bill;
import com.ortiz.billsplitter.Models.Item;
import com.ortiz.billsplitter.R;
import com.ortiz.billsplitter.Service.BillsService;
import com.ortiz.billsplitter.Service.ItemService;
import com.ortiz.billsplitter.ViewHolders.BillsViewHolder;
import com.ortiz.billsplitter.ViewHolders.ItemsViewHolder;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemsViewHolder>  {
    Context context;
    List<Item> items;
    private SelectListener listener;
    private ItemService itemService;

    public ItemAdapter(Context context, List<Item> items, SelectListener listener, ItemService itemService)
    {
        this.context = context;
        this.items = items;
        this.listener = listener;
        this.itemService = itemService;
    }

    @NonNull
    @Override
    public ItemsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new ItemsViewHolder(LayoutInflater.from(context).
                inflate(R.layout.rv_items_item_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemsViewHolder holder, int position) {
        holder.tvBillItemName.setText(items.get(position).getName());
        holder.tvBillItemSubtotal.setText(items.get(position).getSubtotal().toString());

        holder.itemView.setOnClickListener(view -> {
            RecyclerView recyclerView = itemService.fetchRecyclerView();
            if (recyclerView == null)
            {
                Log.e("RecyclerView", "The recycler view in the onClick is empty.");
                return;
            }
            Item clickedItem = items.get(holder.getAdapterPosition());
            listener.onItemClicked(clickedItem);
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
