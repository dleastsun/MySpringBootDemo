package com.eai.common.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
/**
 * 
 * @author xudong.li
 *
 */
public class SpringContextUtil  implements ApplicationContextAware {
	
	private static ApplicationContext applicationContext;
 
	//获取上下文
	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}
 
	//设置上下文
	public  void setApplicationContext(ApplicationContext applicationContext) {
		SpringContextUtil.applicationContext = applicationContext;
	}
 
	//通过名字获取上下文中的bean
	public static Object getBean(String name){
		return applicationContext.getBean(name);
	}
	
	//通过类型获取上下文中的bean
	public static <T> T getBean(Class<T> requiredType){
		return applicationContext.getBean(requiredType);
	}
	
	//通过name,以及Clazz返回指定的Bean
    public static <T> T getBean(String name,Class<T> clazz){
        return getApplicationContext().getBean(name, clazz);
    }
 
}