package com.example.springboot;

import com.example.springboot.classes.Item;
import com.example.springboot.classes.Menu;
import com.example.springboot.classes.OrderManager;
import com.example.springboot.classes.Size;
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
		Item item = this.menu.getBeverage(name);
		 return this.getItemNameAndPrice(item);
	 }

	@GetMapping("/appetizer/{name}")
	public String getAppetizer(@PathVariable String name) {
		Item item = this.menu.getAppetizer(name);
		return this.getItemNameAndPrice(item);
	}

	@GetMapping("/pizza/{name}")
	public String getPizza(@PathVariable String name) {
		Item item = this.menu.getPizza(name);
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

			//	Handle setting the size
			String size = (String) ((LinkedHashMap) details).get("size");
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
			Item item = this.menu.getItem(itemName);
			item.setSize(sizeEnum);

			// Grab the quantity
			Integer quantity = (Integer) ((LinkedHashMap) details).get("quantity");
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
