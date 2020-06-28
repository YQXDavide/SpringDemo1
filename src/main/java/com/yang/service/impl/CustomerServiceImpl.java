package com.yang.service.impl;

import java.util.List;

import com.yang.dao.CustomerDao;
import com.yang.entity.Customer;
import com.yang.factory.Factory;
import com.yang.factory.FactoryByIO;
import com.yang.service.CustomerService;

public class CustomerServiceImpl implements CustomerService{
	private CustomerDao customerDao = (CustomerDao) Factory.getBean("customerDao");
	@Override
	public void saveCustomer() {
		System.out.println("业务层调用数据层存Customer");
		customerDao.saveCustomer();
		
	}

	@Override
	public Customer selectOne(int Id) {
		System.out.println("业务层调用数据层根据Id查询Customer");
		return customerDao.selectOne(1);
	}

	@Override
	public List<Customer> selectAll() {
		System.out.println("业务层调用数据层根据查询Customer列表");
		return customerDao.selectAll();
	}

	@Override
	public void update(int Id) {
		System.out.println("业务层调用数据层更新Customer");
		customerDao.update(1);
	}

	@Override
	public void delete(int Id) {
		System.out.println("业务层调用数据层删除Customer");
		customerDao.delete(1);
	}

}	
