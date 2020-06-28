package com.yang.dao;

import java.util.List;

import com.yang.entity.Customer;

public interface CustomerDao {
	void saveCustomer();
	
	Customer selectOne(int Id);
	
	List<Customer> selectAll();
	
	void update(int Id);
	
	void delete(int Id);
}
