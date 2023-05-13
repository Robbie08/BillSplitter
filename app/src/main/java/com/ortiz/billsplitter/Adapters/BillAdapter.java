package com.ortiz.billsplitter.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ortiz.billsplitter.Listeners.SelectListener;
import com.ortiz.billsplitter.Models.Bill;
import com.ortiz.billsplitter.R;
import com.ortiz.billsplitter.ViewHolders.BillsViewHolder;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

public class BillAdapter extends RecyclerView.Adapter<BillsViewHolder> {
    Context context;
    List<Bill> bills;
    private SelectListener listener;

    public BillAdapter(Context context, List<Bill> bills, SelectListener listener)
    {
        this.context = context;
        this.bills = bills;
        this.listener = listener;
    }

    @NonNull
    @Override
    public BillsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new BillsViewHolder(LayoutInflater.from(context).inflate(R.layout.bill_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull BillsViewHolder holder, int position) {
        String pattern = "MM/dd/yyyy HH:mm:ss";
        DateFormat df = new SimpleDateFormat(pattern);

        String date = df.format(bills.get(position).getDate());
        holder.billName.setText(bills.get(position).getName());
        holder.billDate.setText(date);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClicked(bills.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return bills.size();
    }
}
