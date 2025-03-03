package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.dto.OrderFormDto;
import com.example.service.orderService;

@Controller
public class OrderController {
	
	@Autowired
	orderService orderservice;

	@PostMapping("/confirm-order")
	public String confirmOrder(
			@RequestBody OrderFormDto cartRequest,
	        Model model) {
		   
		System.out.println("cartrequest obj is"+ cartRequest.toString());
		
	   orderservice.SaveOrders(cartRequest);
	    
	    //model.addAttribute("success", "Order confirmed successfully!");
	    return "redirect:"+"/order-confirmation";
	}
	
	@GetMapping("/order-confirmation")
	public String orderConfirmation() {
		
		return "order-confirmation";
	}
	
}
