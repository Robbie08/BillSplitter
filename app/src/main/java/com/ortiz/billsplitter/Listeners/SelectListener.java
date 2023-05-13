package com.ortiz.billsplitter.Listeners;

import android.content.Context;

import com.ortiz.billsplitter.Models.Bill;

public interface SelectListener {

    /**
     * This function handles a click event on a item for a list of bills.
     * @param bill is the bill that was clicked on.
     */
    void onItemClicked(Bill bill);
}
