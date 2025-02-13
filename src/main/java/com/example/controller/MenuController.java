package com.example.controller;


import java.awt.MenuItem;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.entity.Menu;
import com.example.service.MenuService;


@Controller
public class MenuController {
	
	@Autowired
	MenuService menuservice;
	
	@GetMapping("api/qr/getmenu")
	public String getMenu(Model model){
		
		List<Menu> menu=menuservice.getMenu();
		
		
		 
		 model.addAttribute("menu", menu);
		 

		 
		 return "menu";
	

}
	
	@PostMapping("/add-to-cart")
	public String addToCart(@RequestParam Map<String, String> quantities, Model model) {
		System.out.println(quantities);
	    Map<Menu, Integer> cart = new HashMap<>();

	    for (Map.Entry<String, String> entry : quantities.entrySet()) {
	        String itemId = entry.getKey();
	        String quantity = entry.getValue();
	        
	        int id=Integer.parseInt(itemId);
	        int quan=Integer.parseInt(quantity);

	        if (quan > 0) {
	            Menu item = menuservice.findMenuItemById(id); // Assume you have a service to fetch items
	            cart.put(item, quan);
	        }
	    }

	    model.addAttribute("cart", cart);
	    return "cart"; // Return the cart view
	}

	

	
	

}
