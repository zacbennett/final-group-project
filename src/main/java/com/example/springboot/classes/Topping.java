package com.example.springboot.classes;

public enum Topping {

    PINEAPPLE {
        public float getCost() {
            return 4;
        }
    },
    JALAPENOS {
        public float getCost() {
            return 3;
        }
    },
    ONIONS {
        public float getCost() {
            return 4;
        }
    };

    public abstract float getCost();
}
