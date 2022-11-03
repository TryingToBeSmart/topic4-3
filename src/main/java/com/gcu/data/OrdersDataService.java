package com.gcu.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.gcu.data.entity.OrderEntity;
import com.gcu.data.repository.OrdersRepository;
import com.gcu.model.OrderModel;

@Service
public class OrdersDataService<T> implements DataAccessInterface<T> {
	@Autowired
	private DataSource datasource;
	OrderModel orderModel = new OrderModel(0, null, null, 0, 0);
	
	@Autowired
	private JdbcTemplate jdbcTemplateObject;
	
	@Autowired
	private OrdersRepository ordersRepository;
	
	/**
Non-default constructor that takes an instance of OrdersRepository as a method
argument that initializes the class-scoped instance variable. This is required to
support constructor injection of the Repository in this service class.
	 */
	public OrdersDataService(OrdersRepository ordersRepository, DataSource dataSource) {
		this.ordersRepository = ordersRepository;
		this.datasource = dataSource;
		//Spring will use constructor injection to initialize this class.
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	/**
	 * Create a variable name orders of type List<OrderEntity> and initialize it
to an empty ArrayList<OrderEntity>.
ii. Call the findAll() method on the ordersRepository class scoped variable
and assign the return value to a variable named orderIterable of type
Iterable<OrderEntity) name.
iii. Convert the Iterable<OrderEntity> to a List<OrderEntity> by calling the
forEach(orders::add) method on the orderIterable.
iv. Return the orders List.
v. Surround all logic with a try catch block that for now just prints the stack
trace to the console.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		List<OrderEntity> orders = new ArrayList<OrderEntity>();
		
		try {	
			//get all the entity orders
			Iterable<OrderEntity> orderIterable = ordersRepository.findAll();
			
			//add ordersRepository to the orders list
			orderIterable.forEach(orders::add);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return (List<T>) orders;
	}

	@Override
	public T findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean create(OrderEntity order) {
		//example of overriding the CrudRepository in save() because it simply is never called
		//you can inject a datasource and use the jdbcTemplate to provide a customized implementation
		//of a save() method
		String sql = "INSERT INTO ORDERS(ORDER_NO, PRODUCT_NAME, PRICE, QUANITY VALUES(?,?,?,?)";
		try {
			//EXECUTE SQL insert
			jdbcTemplateObject.update(sql, order.getOrderNo(), order.getProductName(), order.getPrice(), order.getQuantity());
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean update(T t) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean delete(T t) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean create(T t) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
