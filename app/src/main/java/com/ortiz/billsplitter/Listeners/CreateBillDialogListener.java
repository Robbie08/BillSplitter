package com.ortiz.billsplitter.Listeners;

import androidx.recyclerview.widget.RecyclerView;

import com.ortiz.billsplitter.Models.Bill;

import java.util.List;

public interface CreateBillDialogListener {
    void applyText(String billName, RecyclerView recyclerView, List<Bill> bills);
}
