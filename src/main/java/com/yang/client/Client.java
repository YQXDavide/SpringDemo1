package com.yang.client;

import com.yang.factory.Factory;
import com.yang.factory.FactoryByClassLoader;
import com.yang.factory.FactoryByIO;
import com.yang.service.CustomerService;

public class Client {
	public static void main(String[] args) {
		//通过ResourceBundle来加载配置文件
		CustomerService service = (CustomerService) Factory.getBean("customerService");
		service.saveCustomer();
		service.delete(1);
		//通过IO来加载配置文件
//		CustomerService service = (CustomerService) FactoryByIO.getBean("customerService");
//		service.saveCustomer();
		//通过类加载器加载配置文件,配置文件需要在类路径下
//		CustomerService service = (CustomerService) FactoryByClassLoader.getBean("customerService");
//		service.saveCustomer();
	}
}
