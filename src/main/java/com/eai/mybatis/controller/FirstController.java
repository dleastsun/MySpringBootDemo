package com.eai.mybatis.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("first")
public class FirstController {
	private final static Logger LOGGER = LoggerFactory.getLogger(FirstController.class);

	@RequestMapping(value = { "/get/{id}" })
	public String first(@PathVariable("id") Integer id) {
		LOGGER.info("id=============="+id.toString());
		return null;
	}

	@RequestMapping(value = { "/say" })
	public String say(@RequestParam("id") String myId) {
		LOGGER.info("myId==========="+myId);
		return "id:" + myId;
	}

}
