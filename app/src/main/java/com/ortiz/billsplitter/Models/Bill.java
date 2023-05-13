package com.ortiz.billsplitter.Models;

import java.util.*;

public class Bill {
    private String name;
    private List<Item> items;
    private Double subTotal;
    private Double tax;
    private Double total;
    private Double tip;
    private Date date;
    private Map<User, Double> expensePerUser;
    private String uuid;


    public Bill(){
        this.uuid = UUID.randomUUID().toString();
    }

    public Bill(String name, Date date)
    {
        this.name = name;
        this.date = date;

    }
    public Bill(String name, List<Item> items, Double subTotal, Double tax, Double total, Double tip, Date date)
    {
        this.name = name;
        this.items = items;
        this.subTotal = subTotal;
        this.tax = tax;
        this.total = total;
        this.tip = tip;
        this.date = date;
        this.expensePerUser = expensePerUser;
        this.uuid = UUID.randomUUID().toString();
    }

    public Bill(String name, List<Item> items, Double subTotal, Double tax, Double total, Double tip, Date date, Map<User, Double> expensePerUser) {
        this.name = name;
        this.items = items;
        this.subTotal = subTotal;
        this.tax = tax;
        this.total = total;
        this.tip = tip;
        this.date = date;
        this.expensePerUser = expensePerUser;
        this.uuid = UUID.randomUUID().toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getTip() {
        return tip;
    }

    public void setTip(Double tip) {
        this.tip = tip;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Map<User, Double> getExpensePerUser() {
        return expensePerUser;
    }

    public void setExpensePerUser(Map<User, Double> expensePerUser) {
        this.expensePerUser = expensePerUser;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}

