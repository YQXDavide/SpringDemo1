package com.yang.factory;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 通过类加载器加载配置文件
 * 1.创建properties对象
 * 2.通过classLoader的getResourceAsStream方法来加载配置文件
 * 3.通过load方法来读取配置文件
 * @author yang
 *
 */
public class FactoryByClassLoader {
	private static Properties prop = new Properties();
	private static Map<String,Object> beans = new HashMap<>();
	static {
		try {
			InputStream in = FactoryByClassLoader.class.getClassLoader().getResourceAsStream("com/yang/bean.properties");
			prop.load(in);
			Enumeration<String> keys = (Enumeration<String>) prop.propertyNames();
			while(keys.hasMoreElements()) {
				String key = keys.nextElement();
				String beanPath = prop.getProperty(key);
				Object value = Class.forName(beanPath).newInstance();
				beans.put(key, value);
			}
		} catch (Exception e) {
			throw new ExceptionInInitializerError("容器初始化失败！！");
		}
	}
	
	public static Object getBean(String beanName) {
		return beans.get(beanName);
	}
}
