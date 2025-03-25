package com.example.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.dto.MenuDto;
import com.example.entity.Menu;
import com.example.service.MenuService;


@Controller
public class MenuController {
	
	@Autowired
	MenuService menuservice;
	
	
	@GetMapping("/")
	public String Home(Model model) {
			
		List<Menu> menu=menuservice.getMenu();
		
		
		 
		 model.addAttribute("menu", menu);
		 
			return "menu";
		
	}
	
	@GetMapping("/contact")
	public String Contact() {
			
			return "contact";
		
	}
	
	
	@GetMapping("api/qr/getmenu/{RoomId}")
	public String getMenu(@PathVariable String RoomId ,Model model){
		
		List<Menu> menu=menuservice.getMenu();
		
		
		 model.addAttribute("RoomId",RoomId);
		 model.addAttribute("menu", menu);
		 

		 
		 return "menu";
	

}
	
	@PostMapping("/add-to-cart")
	public String addToCart(@RequestParam Map<String, String> quantities,@RequestParam String RoomId,
			Model model) {
		System.out.println(quantities);
		System.out.println("RoomId is:"+RoomId);
	    Map<Menu, Integer> cart = new HashMap<>();

	    for (Map.Entry<String, String> entry : quantities.entrySet()) {
	        String itemId = entry.getKey();
	        String quantity = entry.getValue();
	        
	        if(!itemId.equalsIgnoreCase("RoomId")) 
	        {
	        int id=Integer.parseInt(itemId);
	        int quan=Integer.parseInt(quantity);
	        

	        if (quan > 0) {
	            Menu item = menuservice.findMenuItemById(id); // Assume you have a service to fetch items
	            cart.put(item, quan);
	        }
	        }
	    }
        model.addAttribute("RoomId",RoomId);
	    model.addAttribute("cart", cart);
	    return "cart"; // Return the cart view
	}
    
	@GetMapping("/manager-menu")
	public ResponseEntity<List<Menu>> manageMenu(Model model) {
			
		List<Menu> menu=menuservice.getMenu();
		
		
		 
		// model.addAttribute("menu", menu);
		 
		 return ResponseEntity.status(HttpStatus.ACCEPTED).body(menu);
		
	}
	
	@PostMapping("/add-to-menu")
	public ResponseEntity<String> addnewMenuItem(@RequestBody MenuDto menuitem){
		
		Menu menu=menuservice.addnewMenuitem(menuitem);
		
		if(menu!=null) {
			return ResponseEntity.ok("Menu Item added succesfully");
		}
		
		 return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to add Menu Item");
		
	}
	
	@PostMapping("/update-menu")
	public ResponseEntity<String> UpdateMenuItem(@RequestBody Menu menu){
		
		Menu menu1=menuservice.updateMenuitem(menu);
		
		if(menu1!=null) {
			return ResponseEntity.ok(menu1.toString());
		}
		
		 return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to update Menu Item");
		
	}
	

	
	

}
