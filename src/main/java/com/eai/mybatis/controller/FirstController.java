package com.eai.mybatis.controller;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("first")
public class FirstController {
	private final static Logger LOGGER = LoggerFactory.getLogger(FirstController.class);
	
	@Value(value="${eai.secret}")
	private String secret;
	
	@Value(value="${eai.number}")
	private String number;

	@RequestMapping(value = { "/get/{id}" })
	public String first(@PathVariable("id") Integer id) {
		
		LOGGER.info("secret===="+secret);
		LOGGER.info("number===="+number);
		
		LOGGER.info("id==============" + id.toString());
		return "hello world";
	}

	@RequestMapping(value = { "/say" })
	public HashMap<String, Object> say(@RequestParam("name") String name) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("title", "hello world");
		map.put("name", name);
		return map;
	}

}
