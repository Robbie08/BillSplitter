package com.ortiz.billsplitter.Service;

import com.ortiz.billsplitter.Models.Bill;

import java.util.List;

public interface BillsService {

    public Bill createBill(String name, Double subtotal, Double tax, Double tip);

    void insertBillIntoRecyclerView(Bill bill, List<Bill> bills);
}
