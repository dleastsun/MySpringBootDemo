package com.eai.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eai.common.utils.SpringContextUtil;
import com.eai.mybatis.service.XMLService;

/**
 * 自定义servlet
 * 
 * @author xudong.li
 */
public class CustomServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("servlet get method");
		XMLService service =(XMLService)SpringContextUtil.getBean("xmlService");
		
		Map<String, Object> reqMap=new HashMap<String,Object>();
		reqMap.put("id", "1000");
		reqMap.put("name", "lixudong");
		reqMap.put("age", 100);
		service.createUser(reqMap);
		
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("servlet post method");
		response.getWriter().write("hello world");
	}

}
