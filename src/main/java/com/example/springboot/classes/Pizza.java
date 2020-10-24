package com.example.springboot.classes;
import com.example.springboot.classes.Item;
import com.example.springboot.classes.*;
import com.example.springboot.classes.Size;


public class Pizza extends Item {
 
    private float totalPrice = 0;

    private Size size;
    private Topping topping;
    private Crust crust;
    private Cheese cheese;

    public Pizza(String name, double price, Topping topping, Crust crust) {
        super(name, price);
        this.topping = topping;
        this.crust = crust;
    }

    public Size getSize() {
        return size;
    }
 
    public void setPizzaSize(Size size) {
        this.size = size;
    }
 
    public Topping getTopping() {
        return topping;
    }
 
    public void setPizzaTopping(Topping topping) {
        this.topping = topping;
    }
 
    public Crust getCrust() {
        return crust;
    }
 
    public void setPizzaCrust(Crust crust) {
        this.crust = crust;
    }
 
    public Cheese getCheese() {
        return cheese;
    }
 
    public void setCheese(Cheese cheese) {
        this.cheese = cheese;
    }
 
    public float getTotalPrice() {
        return totalPrice;
    }
 
    public void addPizzaPrice(float price) {
        this.totalPrice = totalPrice + price;
    }
}


