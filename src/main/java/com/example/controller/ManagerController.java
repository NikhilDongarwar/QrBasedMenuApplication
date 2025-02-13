package com.example.controller;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.entity.OrderForm;
import com.example.repo.orderRepo;

@Controller
public class ManagerController {
	
	@Autowired
	orderRepo orderrepo;

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
    public ResponseEntity<OrderForm> viewOrderDetails(@PathVariable int orderId) {
        Optional<OrderForm> order = orderrepo.findById(orderId);
        if (order.isPresent()) {
            return ResponseEntity.ok(order.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
