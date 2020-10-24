package com.example.springboot.classes;

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
