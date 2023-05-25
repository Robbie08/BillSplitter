package com.ortiz.billsplitter.Listeners;

import android.content.Context;

import com.ortiz.billsplitter.Models.Bill;
import com.ortiz.billsplitter.Models.Item;

public interface SelectListener {

    /**
     * This function handles a click event on a item for a list of bills.
     * @param bill is the bill that was clicked on.
     */
    void onItemClicked(Bill bill);


    /**
     * This function handles a click event on a item for a list of items.
     * @param item is the item that was clicked on.
     */
    void onItemClicked(Item item);
}
