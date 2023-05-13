package com.ortiz.billsplitter.ViewHolders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ortiz.billsplitter.R;

public class BillsViewHolder extends RecyclerView.ViewHolder {
    
    public TextView billName;
    public TextView billDate;
    View view;
    public BillsViewHolder(@NonNull View itemView) {
        super(itemView);
        billName = (TextView) itemView.findViewById(R.id.billName);
        billDate = (TextView) itemView.findViewById(R.id.billDate);
        //view = itemView;
    }
}
