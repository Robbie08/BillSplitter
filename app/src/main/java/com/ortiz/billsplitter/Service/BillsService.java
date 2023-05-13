package com.ortiz.billsplitter.Service;

import androidx.recyclerview.widget.RecyclerView;

import com.ortiz.billsplitter.Models.Bill;

import java.util.List;

public interface BillsService {

    /**
     * @return fetches the recycler view used by the component
     */
    RecyclerView fetchRecyclerView();

    /**
     *
     * @param name of the bill we want to create
     * @return Creates an a bill with only the name and date as set values
     */
    Bill createBill(String name);

    /**
     * This function adds the bill into the recycler view.
     * @param bill the bill we want to insert into recycler view
     * @param bills the list of bills relevant to the recycler view
     */
    void insertBillIntoRecyclerView(Bill bill, List<Bill> bills);
}
