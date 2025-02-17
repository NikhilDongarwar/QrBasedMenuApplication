package com.example.controller;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.dto.OrderItemsDto;
import com.example.dto.showOrderDto;
import com.example.entity.CartEntry;
import com.example.entity.OrderForm;
import com.example.repo.CartEntryRepo;
import com.example.repo.orderRepo;

@Controller
public class ManagerController {
	
	@Autowired
	orderRepo orderrepo;
	
	@Autowired
	CartEntryRepo cartentryRepo;

    @GetMapping("/manager/login")
    public String showLoginPage() {
        return "manager-login"; // Renders manager-login.html
    }

    @PostMapping("/manager/login")
    public String handleLogin(@RequestParam String username, @RequestParam String password, Model model) {
        if ("admin".equals(username) && "password".equals(password)) {
            return "redirect:/manager/dashboard"; // Redirect to dashboard on successful login
        } else {
            model.addAttribute("error", "Invalid username or password.");
            return "manager-login";
        }
    }

    @GetMapping("/manager/dashboard")
    public String showDashboard() {
        return "manager-dashboard"; // Renders manager-dashboard.html
    }

    @GetMapping("/manager/orders/{orderId}")
    public ResponseEntity<showOrderDto> viewOrderDetails(@PathVariable int orderId) {
        Optional<OrderForm> order = orderrepo.findById(orderId);
        List<CartEntry> cartentrylist=cartentryRepo.findByOrderformOrderId(orderId);
        showOrderDto showorder=new showOrderDto();
        showorder.setOrderId(order.get().getOrderId());
        LocalDateTime dateTime = LocalDateTime.parse(order.get().getOrderDate(), DateTimeFormatter.ISO_DATE_TIME);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String formattedDate = dateTime.format(formatter);
        System.out.println(formattedDate);
        
        showorder.setOrderDate(formattedDate);
        showorder.setTotalAmount(order.get().getTotalAmount());
        List<OrderItemsDto> orderitemsdtolist =new CopyOnWriteArrayList<>();
        for(CartEntry cartentry:cartentrylist) {
        	OrderItemsDto orderitems=new OrderItemsDto();
        	orderitems.setName(cartentry.getName());
        	orderitems.setQuantity(cartentry.getQuantity());
        	orderitems.setPrice(cartentry.getPrice());
        	orderitemsdtolist.add(orderitems);
        }
        showorder.setOrderitems(orderitemsdtolist);
        
        return ResponseEntity.ok(showorder);
    }
}
