package com.yang.dao.impl;

import java.util.List;

import com.yang.dao.CustomerDao;
import com.yang.entity.Customer;

public class CustomerDaoImpl implements CustomerDao {

	@Override
	public void saveCustomer() {
		System.out.println("数据层存Customer");
		
	}

	@Override
	public Customer selectOne(int Id) {
		System.out.println("数据层根据Id查询Customer");
		return null;
	}

	@Override
	public List<Customer> selectAll() {
		System.out.println("数据层查询Customer列表");
		return null;
	}

	@Override
	public void update(int Id) {
		System.out.println("数据层更新Customer");
		
	}

	@Override
	public void delete(int Id) {
		System.out.println("数据层删除Customer");
		
	}

}
