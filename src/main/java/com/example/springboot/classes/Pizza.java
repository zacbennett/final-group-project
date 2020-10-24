package com.example.springboot.classes;
import com.example.springboot.classes.Item;


public class Pizza {
 
    private float totalPrice = 0;

    private Size size;
    private Topping topping;
    private Crust crust;
    private Cheese cheese;
 
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



public enum Crust {
    THIN  {
        public float getCost(){
            return 3;
        }
    },
    STUFFED{
        public float getCost(){
            return 4;
        }
    };
 
    public abstract float getCost();
}

public enum Size {
    SMALL {
        public float getCost() {
            return 15;
        }
    },
    MEDIUM {
        public float getCost() {
            return 20;
        }
    },
    LARGE {
        public float getCost() {
            return 25;
        }
    };
 
    public abstract float getCost();
}

public enum Topping {

    PINEAPPLE {
        public float getCost(){
            return 4;
        }
    }, 
    JALAPENOS{
        public float getCost(){
            return 3;
        }
    }, 
    ONIONS{
        public float getCost(){
            return 4;
        }
    };
 
    public abstract float getCost();
}

public enum Cheese {
    AMERICAN {
        public float getCost() {
            return 5;
        }
    },
    CHEDDAR {
        public float getCost() {
            return 5;
        }
    };
 
    public abstract float getCost();
 
}
