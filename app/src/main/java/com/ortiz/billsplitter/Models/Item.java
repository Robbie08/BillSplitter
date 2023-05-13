package com.ortiz.billsplitter.Models;

import java.util.List;
import java.util.UUID;

public class Item {
    private String name;

    private Double subtotal;

    private List<User> consumers;

    private String uuid;

    public Item() {
        this.uuid = UUID.randomUUID().toString();
    }

    public Item(String name, Double subtotal)
    {
        this.name = name;
        this.subtotal = subtotal;
        this.uuid = UUID.randomUUID().toString();
    }

    public Item(String name, Double subtotal, List<User> consumers) {
        this.name = name;
        this.subtotal = subtotal;
        this.consumers = consumers;
        this.uuid = UUID.randomUUID().toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public List<User> getConsumers() {
        return consumers;
    }

    public void setConsumers(List<User> consumers) {
        this.consumers = consumers;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
