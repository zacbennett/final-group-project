package com.example.springboot.classes;

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
