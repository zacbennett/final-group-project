package com.example.springboot;
import com.example.springboot.classes.Item;
import com.example.springboot.classes.OrderManager;
import org.springframework.web.bind.annotation.*;
import com.example.springboot.classes.Menu;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


@RestController
public class HelloController {
	private final OrderManager orderManager;
	private Menu menu;


	public HelloController() {
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
		if(item != null) {
			return item.getNameAndPrice();
		} else {
			return "No item found";
		}
	 }

	@GetMapping("/appetizer/{name}")
	public String getAppetizer(@PathVariable String name) {
		Item item = this.menu.getAppetizer(name);
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

			Integer quantity = (Integer) ((LinkedHashMap) details).get("quantity");
			Item item = this.menu.getItem(itemName);

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
