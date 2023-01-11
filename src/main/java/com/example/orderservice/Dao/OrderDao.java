package com.example.orderservice.Dao;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Repository;

import com.example.orderservice.entity.Order;

@Repository
public class OrderDao {

	public List<Order> getOrders(){
		
		return Stream.of(new Order(101, "Mobile", 1, 30000),
				new Order(58, "Book", 4, 2000),
				new Order(205, "Laptop", 1, 150000),
				new Order(809, "headset", 1, 1799))
				.collect(Collectors.toList());
	}
	
	public Order getOrderById(int id) {
		
		return getOrders().stream().filter(O -> O.getId() == id).findAny().get();
	}
}
