package com.example.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.CartEntryDTO;
import com.example.dto.OrderFormDto;
import com.example.entity.CartEntry;
import com.example.entity.Notification;
import com.example.entity.OrderForm;
import com.example.repo.CartEntryRepo;
import com.example.repo.orderRepo;

@Service
public class orderService {
	
	@Autowired
	orderRepo orderrepo;
	
	@Autowired
	CartEntryRepo cartentryrepo;
	
	@Autowired
	NotificationService notificationService;
	
	

	public void SaveOrders(OrderFormDto orderFormdto) {
		OrderForm orderform=new OrderForm();
		orderform.setOrderDate(orderFormdto.getOrderDate());
		orderform.setStatus(orderFormdto.getStatus());
		orderform.setTotalAmount(orderFormdto.getTotalAmount());
	     try {
		   orderrepo.save(orderform);
	     }
	     catch(Exception e) {
	    	 System.out.println(e.getMessage());
	     }
	     for(CartEntryDTO cartentrydto:orderFormdto.getCartEntries()) {
	    	 CartEntry cartentry=new CartEntry();
	    	 cartentry.setOrderform(orderform);
	    	 cartentry.setName(cartentrydto.getName());
	    	 cartentry.setDescription(cartentrydto.getDescription());
	    	 cartentry.setPrice(cartentrydto.getPrice());
	    	 cartentry.setQuantity(cartentrydto.getQuantity());
	    	 cartentry.setSubtotal(cartentrydto.getSubtotal());
	    	 
	    	 cartentryrepo.save(cartentry);
	    	 
	     }
	     Notification notification = new Notification();
	     notification.setMessage("New order received");
	     notification.setOrderId(orderform.getOrderId());
	     notificationService.sendNotification(notification);
	     
	     
	     
	}
		
		
		
	}


