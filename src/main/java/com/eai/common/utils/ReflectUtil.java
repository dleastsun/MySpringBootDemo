package com.eai.common.utils;

import java.lang.reflect.Array;

import org.apache.commons.beanutils.BeanUtils;

import com.eai.springbatch.model.Student;
import com.eai.springbatch.model.User;

/**
 *
 * @author xudong.li
 *
 */
public class ReflectUtil {

	/**
	 *
	 * @param clazz
	 * @return
	 */
	public static <T> T clazzToObject(Class<T> clazz) {
		Object obj = null;
		try {
			obj = clazz.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (T) obj;
	}

	/**
	 *
	 * @param className
	 * @return
	 */
	public static <T> T clazzToObject(String className) {
		Object obj = null;
		try {
			Class clazz = Class.forName(className);
			obj = clazz.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (T) obj;
	}

	public static void copyProperties(Object target, Object source) throws Exception {
		BeanUtils.copyProperties(target, source);

	}

	public static void copyProperties(Object target, String name, Object source) throws Exception {
		BeanUtils.copyProperty(target, name, source);
	}

	public static void main(String[] args) throws Exception {
		Student s1 = new Student();
		s1.setName("123");
		s1.setScore("999");
		Student s2 = new Student();
		s2.setName("456");
		Student[] s = new Student[] { s1, s2 };

		String[] a = { "name" ,"score"};

		User[] u = copyArrayProperties(User.class, s, a);

		System.out.println("------------" + u[0].getName()+"  "+u[0].getScore());
		System.out.println("------------" + u[1].getName());

	}

	public static <T1, T2> T2[] copyArrayProperties(Class<T2> clazz2, T1 source[], String[] fieldNames)
			throws Exception {
		// T2 t = clazz2.newInstance();
		
		@SuppressWarnings("unchecked")
		T2[] array = (T2[]) Array.newInstance(clazz2, source.length);

		for (int i = 0; i < source.length; i++) {
			array[i] = clazz2.newInstance();
			for (int j = 0; j < fieldNames.length; j++) {
				ReflectUtil.copyProperties(array[i], fieldNames[j], BeanUtils.getProperty(source[i], fieldNames[j]));
			}
		}

		return array;
	}

}
