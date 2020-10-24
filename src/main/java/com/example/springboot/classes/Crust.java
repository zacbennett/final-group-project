package com.example.springboot.classes;

public enum Crust {
    THIN {
        public float getCost() {
            return 3;
        }
    },
    STUFFED {
        public float getCost() {
            return 4;
        }
    };

    public abstract float getCost();
}
