package com.ortiz.billsplitter.ViewHolders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ortiz.billsplitter.R;

public class ItemsViewHolder extends RecyclerView.ViewHolder{

    public TextView tvBillItemName;
    public TextView tvBillItemSubtotal;
    public ItemsViewHolder(@NonNull View itemView) {
        super(itemView);
        tvBillItemName = (TextView) itemView.findViewById(R.id.tvBillItemName);
        tvBillItemSubtotal = (TextView) itemView.findViewById(R.id.tvBillItemSubtotal);
    }
}
