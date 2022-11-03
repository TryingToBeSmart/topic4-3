package com.gcu.data.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import com.gcu.data.entity.OrderEntity;

public interface OrdersRepository extends CrudRepository<OrderEntity, Long> {
	//overriding method from the CrudRepository using customized SQL
	@Override
	@Query(value= "SELECT * FROM ORDERS")
	public List<OrderEntity> findAll();
}
