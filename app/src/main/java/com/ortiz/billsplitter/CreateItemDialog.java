package com.ortiz.billsplitter;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.recyclerview.widget.RecyclerView;

import com.ortiz.billsplitter.Models.Bill;
import com.ortiz.billsplitter.Models.Item;
import com.ortiz.billsplitter.Models.User;
import com.ortiz.billsplitter.Service.BillsService;
import com.ortiz.billsplitter.Service.ItemService;

import java.util.List;

public class CreateItemDialog extends AppCompatDialogFragment {

    private EditText etBillName;
    private RecyclerView recyclerView;
    private List<Item> items;
    private Context context;
    private ItemService itemService;

    public CreateItemDialog(List<Item> items, Context context, ItemService itemService)
    {
        this.items = items;
        this.context = context;
        this.itemService = itemService;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_create_bill, null);
        recyclerView = view.findViewById(R.id.recyclerViewBills);

        // This opens the Dialog and allows us to add logic to control the buttons
        builder.setView(view).setTitle("Create Bill")
                .setNegativeButton("cancel", (dialogInterface, i) -> {})
                .setPositiveButton("create", (dialogInterface, i) -> {
                    String billName = etBillName.getText().toString();
                    Log.i("DIALOG", String.format("BillName: %s", billName));
//                    itemService.insertItemIntoRecyclerView(
//                            itemService.createItem(billName, items), bills);

                });

        etBillName = view.findViewById(R.id.dialog_create_bill);
        return builder.create();
    }
}
