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
 
    public void setSize(Size size) {
        this.size = size;
    }
 
    public Topping getTopping() {
        return topping;
    }
 
    public void setTopping(Topping topping) {
        this.topping = topping;
    }
 
    public Crust getCrust() {
        return crust;
    }
 
    public void setCrust(Crust crust) {
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
 
    public void addToPrice(float price) {
        this.totalPrice = totalPrice + price;
    }
}


public enum Cheese {
    AMERICAN {
        public float getCost() {
            return 40;
        }
    }, ITALIAN {
        public float getCost() {
            return 60;
        }
    };
 
    public abstract float getCost();
 
}
 
public enum Crust {
 
      THIN  {
        public float getCost(){
            return 70;
        }
    } , STUFFED{
        public float getCost(){
            return 90;
        }
    };
 
    public abstract float getCost();
}
 
public enum Size {
    MEDIUM {
        public float getCost() {
            return 100;
        }
    }, 

    LARGE {
        public float getCost() {
            return 160;
        }
    };
 
    public abstract float getCost();
}
 
public enum Topping {
 
    PEPPERONI {
        public float getCost(){
            return 30;
        }
    }, CHICKEN{
        public float getCost(){
            return 35;
        }
    }, MUSHROOM{
        public float getCost(){
            return 20;
        }
    };
 
    public abstract float getCost();
}