package com.example.springboot.classes;
import com.example.springboot.classes.Pizza;


public class PizzaBuilder {
 
    Pizza pizza = new Pizza();
 
    public PizzaBuilder withTopping(Topping topping) {
        pizza.setTopping(topping);
        pizza.addToPrice(topping.getCost());
        return this;
    }
 
    public PizzaBuilder withSize(Size size) {
        pizza.setSize(size);
        pizza.addToPrice(size.getCost());
        return this;
    }
 
    public PizzaBuilder withCrust(Crust crust) {
        pizza.setCrust(crust);
        pizza.addToPrice(crust.getCost());
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
    public void shouldBuildThinCrustChickenPizza(){
        Pizza pizza = new PizzaBuilder().withCrust(Crust.THIN).withTopping(Topping.CHICKEN).withSize(Size.LARGE).build();
        assertEquals(Topping.CHICKEN,pizza.getTopping());
        assertEquals(Size.LARGE,pizza.getSize());
        assertEquals(Crust.THIN,pizza.getCrust());
        assertEquals(265.0,pizza.getTotalPrice(),0);
    }
}