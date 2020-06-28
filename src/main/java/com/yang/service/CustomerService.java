package com.yang.service;

import java.util.List;

import com.yang.entity.Customer;

public interface CustomerService {
	void saveCustomer();
	
	Customer selectOne(int Id);
	
	List<Customer> selectAll();
	
	void update(int Id);
	
	void delete(int Id);
}
