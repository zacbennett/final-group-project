package com.example.springboot.classes;
import com.example.springboot.classes.Item;

public class OrderManager {
    private double totalPrice = 0;

    public void addItem(Item item) {
        this.totalPrice += item.getPrice();
    }

    public void addItem(Item item, Integer quantity) {
        for(int i = 0; i < quantity; i++) {
            this.totalPrice += item.getPrice();
        }
    }

    public double getTotalPrice() {
        return this.totalPrice;
    }

    public void clearOrder() {
        this.totalPrice = 0;
    }
}
