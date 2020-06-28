package com.yang.factory;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 通过相对路径，用IO来读取配置文件
 * 1.创建properties对象
 * 2.用load方法与配置文件绑定
 * 3.使用静态初始化
 * 4.用load方法读取内容
 * @author yang
 *
 */
public class FactoryByIO {
	private static Properties prop = new Properties();
	private static Map<String,Object> beans = new HashMap<>();
	static {
		try {
			prop.load(new BufferedInputStream(new FileInputStream(FactoryByIO.class.getResource("/").getPath().concat("com/yang/bean.properties"))));
			Enumeration<String> keys = (Enumeration<String>) prop.propertyNames();
			while(keys.hasMoreElements()) {
				String key = keys.nextElement();
				String beanPath = prop.getProperty(key);
				Object value = Class.forName(beanPath).newInstance();
				beans.put(key, value);
			}
		} catch (Exception e) {
			throw new ExceptionInInitializerError("容器初始化失败");
		}
	}
	
	public static Object getBean(String beanName) {
		return beans.get(beanName);
	}
}
