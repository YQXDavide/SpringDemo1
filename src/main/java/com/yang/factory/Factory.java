package com.yang.factory;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * 因为在程序中是通过类与类之间相互依赖而实现业务逻辑的
 * 因此，每个对象都需要与其合作的对象（也就是它所依赖的对象）的引用
 * 如果合作对象的引用或依赖关系的管理需要由具体的对象来管理，会产生高度耦合
 * 我们可以把这些以来关系通过依赖注入（DI）交给Ioc容器来管理，从而减少依赖，这就是控制反转
 * 
 * 我们为了减少程序的耦合度可以使用反射来创建对象
 * 问题:后期需要更换一个驱动或者更换一个数据库时需要修改源码
 * web项目的话需要把服务器停了再重新部署
 * 所以我们需要尽量避免
 * 
 * 因此我们使用配置文件来解决该问题
 * 那么怎么读取配置文件呢？
 * 1.通过IO流获取相对路径来读取配置文件
 * 	 a.先定义一个properties对象
 * 	 b.使用静态代码块为对象赋值
 * 	 c.使用load方法读取信息
 * 缺点：部署web后会丢失路径
 *     
 * 2.使用类加载器来获取配置文件
 *   a.定义properties对象
 *   b.使用静态代码块为对象赋值
 *   c.使用load方法来读取配置文件
 *   
 *   注意：配置文件需要放在类路径下才行
 *   
 * 3.使用resourceBundle来获取配置文件
 *   a.直接使用ResourceBundle来加载配置文件
 *     ResourceBundle bundle = ResourceBundle.getBundle("配置文件名称：包名+文件名");
 *   b.使用getString方法获取配置文件信息
 *   
 *   注意： 1.ResourceBundle只能用于读取properties文件
 *   	  2.只能用于读取，不能用于输入
 *        3.只能读取类路径下的，不在类路径下读取不了
 *        4.该方法参数是按照包名.类名的方式写的，所以不写扩展名
 * 
 * 使用ResourceBundle来加载配置文件
 * @author yang
 *
 */
public class Factory {
	private static ResourceBundle bundle = ResourceBundle.getBundle("com.yang.bean");
	private static Map<String,Object> beans = new HashMap<>();
	static {
		try {
			Enumeration<String> keys =  bundle.getKeys();
			while(keys.hasMoreElements()) {
				String key = keys.nextElement();
				String beanPath = bundle.getString(key);
				Object value = Class.forName(beanPath).newInstance();
				beans.put(key, value);
			}
		}catch (Exception e) {
				throw new ExceptionInInitializerError("容器初始化失败");
			}
	}
	public static Object getBean(String beanName) {
		return beans.get(beanName);
	}
}
