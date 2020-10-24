package com.example.springboot.classes;

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

    public Item getItem(String name, MenuItem menuItem) {
        // check that the item exists
        Item item = this.items.get(name);
        if(item == null) return null;

        // check that the item is the right type
        Boolean isCorrectType = false;
        switch (menuItem) {
            case APPETIZER:
                isCorrectType = item instanceof Appetizer;
                break;
            case BEVERAGE:
                isCorrectType = item instanceof Beverage;
                break;
            case PIZZA:
                isCorrectType = item instanceof Pizza;
                break;
        }
        return isCorrectType ? item : null;
    }

    public Item getItem(String name) {
        return this.items.get(name);
    }
}