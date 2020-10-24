package com.example.springboot.classes;
import com.example.springboot.classes.Pizza;

public class PizzaBuilder {
    private Crust crust;
    private Topping topping;
    private double price;
    private String name;


    public PizzaBuilder pizzaTopping(Topping topping) {
        this.topping = topping;
        this.price += topping.getCost();
        return this;
    }
    public PizzaBuilder pizzaPrice(double defaultPrice) {
        this.price += defaultPrice;
        return this;
    }

    public PizzaBuilder pizzaCrust(Crust crust) {
        this.crust = crust;
        this.price += crust.getCost();
        return this;
    }
    public PizzaBuilder pizzaName(String name) {
        this.name = name;
        return this;
    }
 
    public Pizza build() {
        return new Pizza(this.name, this.price, this.topping, this.crust);
    }

 
}