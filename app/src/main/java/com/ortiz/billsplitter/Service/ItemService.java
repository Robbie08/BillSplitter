package com.ortiz.billsplitter.Service;

import androidx.recyclerview.widget.RecyclerView;

import com.ortiz.billsplitter.Models.Item;
import com.ortiz.billsplitter.Models.User;

import java.util.List;

public interface ItemService {
    /**
     * @return fetches the recycler view used by the component
     */
    RecyclerView fetchRecyclerView();

    /**
     *
     * @param name of the item we want to create
     * @return Creates an a item with only the name and date as set values
     */
    Item createItem(String name, Double subTotal, List<User> users);

    /**
     * This function adds the item into the recycler view.
     * @param item the item we want to insert into recycler view
     * @param items the list of items relevant to the recycler view
     */
    void insertItemIntoRecyclerView(Item item, List<Item> items);
}
