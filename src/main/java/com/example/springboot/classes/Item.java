package com.example.springboot.classes;
import com.example.springboot.classes.Size;
public class Item {
    private String name;
    private double price;
    private Size size;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }
    public String getName() {
        return this.name;
    }
    public double getPrice() {
        return this.price;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public void setSize(Size size) {
        this.size = size;
        switch (size) {
            case LARGE:
                this.setPrice(this.price * 1.1);
                break;
            case SMALL:
                this.setPrice(this.price * 0.9);
                break;
        }
    }

    public String getNameAndPrice() {
        // TODO Auto-generated method stub
        return this.getName() + ": $" + this.getPrice();
    }
}