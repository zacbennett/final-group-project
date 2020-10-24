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
## Execution

```
Add the execution bit here
```

## UML/Design Diagram

Added as part of the submissions 