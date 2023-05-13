package com.ortiz.billsplitter;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.recyclerview.widget.RecyclerView;

import com.ortiz.billsplitter.Listeners.CreateBillDialogListener;
import com.ortiz.billsplitter.Listeners.CreateBillDialogListenerImpl;
import com.ortiz.billsplitter.Models.Bill;
import com.ortiz.billsplitter.Service.BillsService;

import java.util.Date;
import java.util.List;

public class CreateBillDialog extends AppCompatDialogFragment {

    private EditText etBillName;
    private CreateBillDialogListener listener;
    private RecyclerView recyclerView;
    private List<Bill> bills;
    private Context context;
    private BillsService billsService;

    public CreateBillDialog(List<Bill> bills, Context context, BillsService billsService)
    {
        this.bills = bills;
        this.context = context;
        this.billsService = billsService;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_create_bill, null);
        recyclerView = view.findViewById(R.id.recyclerViewBills);
        listener = new CreateBillDialogListenerImpl(context);


        builder.setView(view).setTitle("Create Bill")
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setPositiveButton("create", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String billName = etBillName.getText().toString();
                        Bill createdBill = new Bill(billName, new Date(System.currentTimeMillis()));
                        billsService.insertBillIntoRecyclerView(createdBill, bills);
                        //listener.applyText(billName);
                        Log.i("BillName", "The bill name is: " + billName);
                    }
                });
        etBillName = view.findViewById(R.id.dialog_create_bill);
        return builder.create();
    }

    @Override
    public void onAttach(@NonNull Context ctxt) {
        super.onAttach(context);
//        try {
//            listener = (CreateBillDialogListener) ctxt;
//        }catch (ClassCastException e)
//        {
//            throw new ClassCastException(e.getMessage());
//        }
    }
}
