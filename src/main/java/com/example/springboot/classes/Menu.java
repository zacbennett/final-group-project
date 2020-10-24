package com.example.springboot.classes;
import com.example.springboot.classes.Item;

import java.util.Map;
import java.util.HashMap;

public class Menu {
    public HashMap<String, Item> items;

    public Menu() {
        this.items = new HashMap<>();
        // key is the param based by the pathparam
        this.items.put("pepsi", new Beverage("Pepsi", 2.99));
        this.items.put("coke", new Beverage("Coke", 1.99));
        this.items.put("breadsticks", new Appetizer("Bread Sticks", 5.00));
        this.items.put("salad", new Appetizer("Salad", 7.50));
        this.items.put("classicCheese", new PizzaBuilder().pizzaCrust(Crust.STUFFED).pizzaName("Classic Cheese").pizzaPrice(12).build());
        this.items.put("spicyPizza", new PizzaBuilder().pizzaCrust(Crust.THIN).pizzaName("Spicy Pizza").pizzaTopping(Topping.JALAPENOS).pizzaPrice(15).build());

    }

    public String printMenu() {
        String menuString = "";
        for (Map.Entry<String,Item> entry : this.items.entrySet()) {
            Item item = entry.getValue();
            menuString = menuString + item.getNameAndPrice() + "\n";
        }
        return menuString;
    }

    public Item getBeverage(String name) {
        // check that the item exists and is a beverage
        Boolean itemExists = this.items.containsKey(name);
        Boolean isBeverage = this.items.get(name) instanceof Beverage;
        if(itemExists && isBeverage) {
            return this.items.get(name);
        } else {
            return null;
        }
    }
    public Item getAppetizer(String name) {
        // check that the item exists and is a appetizer
        Boolean itemExists = this.items.containsKey(name);
        Boolean isAppetizer = this.items.get(name) instanceof Appetizer;
        if(itemExists && isAppetizer) {
            return this.items.get(name);
        } else {
            return null;
        }
    }

    public Item getPizza(String name) {
        // check that the item exists and is a appetizer
        Boolean itemExists = this.items.containsKey(name);
        Boolean isPizza = this.items.get(name) instanceof Pizza;
        if(itemExists && isPizza) {
            return this.items.get(name);
        } else {
            return null;
        }
    }

    public Item getItem(String name) {
        // check that the item exists and is a appetizer
        Boolean itemExists = this.items.containsKey(name);
        if(itemExists) {
            return this.items.get(name);
        } else {
            return null;
        }
    }

}