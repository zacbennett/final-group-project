package com.example.springboot;

import com.example.springboot.classes.*;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


@RestController
public class PizzaController {
	private final OrderManager orderManager;
	private Menu menu;


	public PizzaController() {
		this.menu = new Menu();
		this.orderManager = new OrderManager();
	}

	@GetMapping("/menu")
	public String getMenu() {
		return this.menu.printMenu();
	}

	 @GetMapping("/beverages/{name}")
	 public String getBeverage(@PathVariable String name) {
		Item item = this.menu.getItem(name, MenuItem.BEVERAGE);
		 return this.getItemNameAndPrice(item);
	 }

	@GetMapping("/appetizer/{name}")
	public String getAppetizer(@PathVariable String name) {
		Item item = this.menu.getItem(name, MenuItem.APPETIZER);
		return this.getItemNameAndPrice(item);
	}

	@GetMapping("/pizza/{name}")
	public String getPizza(@PathVariable String name) {
		Item item = this.menu.getItem(name, MenuItem.PIZZA);
		return this.getItemNameAndPrice(item);
	}

	private String getItemNameAndPrice(Item item) {
		if(item != null) {
			return item.getNameAndPrice();
		} else {
			return "No item found";
		}
	}

	// POST /order
	@PostMapping(value = "/order", consumes = "application/json")
	public String post(@RequestBody HashMap<String,Object> payload) {
		//	Example request {"breadsticks": {"quantity": 2}, "pepsi": {"quantity": 1}}
		for (Map.Entry<String, Object> entry : payload.entrySet()) {
			String itemName = entry.getKey();
			Object details = entry.getValue();
			LinkedHashMap detailsMap = ((LinkedHashMap) details);

			// Get the item
			Item item = (Item) this.menu.getItem(itemName);
			if(item == null) return "Invalid Order: No " + itemName + " available";

			//	Set the size
			String size = (String) detailsMap.get("size");
			Size sizeEnum;
			switch (size.toLowerCase()) {
				case "small":
					sizeEnum = Size.SMALL;
					break;
				case "large":
					sizeEnum = Size.LARGE;
					break;
				default:
				case "medium":
					sizeEnum = Size.MEDIUM;
					break;

			}
			item.setSize(sizeEnum);

			// Set the quantity, default to 1
			Integer quantity = (Integer) detailsMap.getOrDefault("quantity", 1);
			if (item != null) {
				this.orderManager.addItem(item, quantity);
			} else {
				return "Item " + itemName + " does not exist";
			}
		}

		// grab total price and clear out the order
		double totalPrice = this.orderManager.getTotalPrice();
		this.orderManager.clearOrder();
		return "Your total is " + totalPrice;
	}
}
