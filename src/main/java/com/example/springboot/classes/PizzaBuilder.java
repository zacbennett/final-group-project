package com.example.springboot.classes;
import com.example.springboot.classes.Pizza;


public class PizzaBuilder {
 
    Pizza pizza = new Pizza();
 
    public PizzaBuilder pizzaTopping(Topping topping) {
        pizza.setPizzaTopping(topping);
        pizza.addPizzaPrice(topping.getCost());
        return this;
    }
 
    public PizzaBuilder pizzaSize(Size size) {
        pizza.setPizzaSize(size);
        pizza.addPizzaPrice(size.getCost());
        return this;
    }
 
    public PizzaBuilder pizzaCrust(Crust crust) {
        pizza.setPizzaCrust(crust);
        pizza.addPizzaPrice(crust.getCost());
        return this;
    }
 
    public Pizza build() {
        return pizza;
    }
 
    public double calculatePrice() {
        return pizza.getTotalPrice();
    }
 
}


public class PizzaBuilderTest {
 
    @Test
    public void testStuffedCrustJalapenosPizza(){
        Pizza pizza = new PizzaBuilder().pizzaCrust(Crust.STUFFED).pizzaTopping(Topping.JALAPENOS).pizzaSize(Size.LARGE).build();
        assertEquals(Topping.JALAPENOS,pizza.getTopping());
        assertEquals(Size.LARGE,pizza.getSize());
        assertEquals(Crust.STUFFED,pizza.getCrust());
        assertEquals(45.0,pizza.getTotalPrice(),0);
    }
}