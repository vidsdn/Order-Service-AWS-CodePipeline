package com.example.orderservice.controller;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.orderservice.Dao.OrderDao;
import com.example.orderservice.entity.Order;

@RestController
//@RequestMapping("/orders")
public class OrderController {
	
	 @Autowired
	    private OrderDao orderDao;

	    @GetMapping("/orders")
	    public List<Order> fetchOrders() {
	        return orderDao.getOrders().stream().
	                sorted(Comparator.comparing(Order::getPrice)).collect(Collectors.toList());
	    }
	    
	    @GetMapping("/orders/{id}")
	    public Order fetchOrderByID(@PathVariable(value="id") int id) {
	    	return orderDao.getOrderById(id);
	    }

}
