# Pizza Ordering System

## Overview

This assignment involves designing a pizza ordering system which creates custom pizzas, and helps the user order appetizers and beverages as well. 

## Requirements

* Features: size/crust/toppings/cheese
* Design Diagram
* Classes and Methods

## API calls
```
curl --location --request POST 'http://localhost:8080/order' \
--header 'Content-Type: application/json' \
--data-raw '{"breadsticks": {"quantity": 2}, "pepsi": {"quantity": 1}}'
```
```
curl --location --request GET 'http://localhost:8080/beverages/pepsi' \
--data-raw ''
```
```
curl --location --request GET 'http://localhost:8080/beverages/nope' \
--data-raw ''
```

## Classes
```
Pizza.class
```
The Pizza class uses a builder pattern to set different parameters critical to the pizza, such as price, toppings, size, cheese, sauce, crust and more

```
PizzaBuilder.class
```
This class helps us build the pizza as per the customisations needed from the user in terms of the sauce, toppings and size needed

```
Topping.class
```
This enum class helps us choose any toppings needed (Onion/Jalapenos/Pineapple)

```
Cheese.class
```
This enum class helps us choose any cheese needed (Cheddar/American)

```
Size.class
```
This enum class helps us choose any size needed (Small/Medium/Large)

```
Crust.class
```
This enum class helps us choose any crust needed (Thin/Stuffed)

```
## Execution/Testing Plan
```
 1. Run the server by running gradlew bootRun in the terminal 
 2. See the menu by calling /menu
 3. See a specific item by calling /beverage/pepsi
 4. See a specific pizza by calling /beverage/classicCheese
 5. Order by passing in your desired items with the size and quantity



 ```
curl --location --request GET 'http://localhost:8080/menu'
```
 ```
curl --location --request GET 'http://localhost:8080/beverages/pepsi'
```
 ```
curl --location --request GET 'http://localhost:8080/pizza/classicCheese'
```
 ```
curl --location --request POST 'http://localhost:8080/order' \
--header 'Content-Type: application/json' \
--data-raw '{"classicCheese": {"quantity": 1, "size": "large"}, "salad": {"quantity": 1, "size": "large"}}'
```
---
```

## UML/Design Diagram

Added as part of the submissions


```
