package com.eai.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eai.common.utils.SpringContextUtil;
import com.eai.mybatis.service.IXMLService;

/**
 * 自定义servlet
 * 
 * @author xudong.li
 */
@WebServlet(name = "myServlet", urlPatterns = "/myServlet")
public class MyServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("servlet get method");
		IXMLService service =(IXMLService)SpringContextUtil.getBean("xmlService");
		
		Map<String, Object> reqMap=new HashMap<String,Object>();
		reqMap.put("id", "999");
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
