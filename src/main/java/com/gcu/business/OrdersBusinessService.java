package com.gcu.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.data.OrdersDataService;
import com.gcu.model.OrderModel;


public class OrdersBusinessService<T> implements OrdersBusinessServiceInterface {

	@SuppressWarnings("rawtypes")
	@Autowired
	OrdersDataService service;
	
	@Override
	public void test() {
		System.out.println("Hello from the OrdersBusinessService");
	}

	/**
	 * Gets the orders.
	 *
	 * @return the orders
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<OrderModel> getOrders() {
		List<OrderModel> orders = service.findAll();
		return orders;
	}

	@Override
	public void init() {
		System.out.println("init");
	}

	@Override
	public void destroy() {
		System.out.println("destroy");
	}

}
