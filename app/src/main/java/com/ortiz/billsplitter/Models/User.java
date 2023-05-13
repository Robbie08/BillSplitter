package com.ortiz.billsplitter.Models;

import java.util.List;
import java.util.UUID;

public class User {
    private String name;

    private List<Bill> bills;

    private String uuid;

    public User(){
        this.uuid = UUID.randomUUID().toString();
    }

    public User(String name)
    {
        this.name = name;
        this.uuid = UUID.randomUUID().toString();
    }

    public User(String name, List<Bill> bills) {
        this.name = name;
        this.bills = bills;
        this.uuid = UUID.randomUUID().toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Bill> getBills() {
        return bills;
    }

    public void setBills(List<Bill> bills) {
        this.bills = bills;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}

