package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
		/*
		 * Map<Menu, Integer> cart=null; try { cart =Cart; } catch (Exception e) { //
		 * TODO Auto-generated catch block e.printStackTrace(); }
		 * System.out.println(cart); System.out.println(totalAmount);
		 */
		/*
		 * if (cart == null || cart.isEmpty()) { model.addAttribute("error",
		 * "Cart is empty. Please add items to confirm the order."); return "cart"; }
		 * 
		 * // Save the order with total amount orderservice.saveOrder(cart,
		 * totalAmount);
		 */
	   orderservice.SaveOrders(cartRequest);
	    // Add a success message
	    model.addAttribute("success", "Order confirmed successfully!");
	    return "order-confirmation";
	}
	
}
