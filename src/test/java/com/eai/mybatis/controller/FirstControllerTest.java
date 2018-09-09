package com.eai.mybatis.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class FirstControllerTest {

	private MockMvc mockMvc;

	@Before
	public void setUp() throws Exception {
		this.mockMvc = MockMvcBuilders.standaloneSetup(new FirstController()).build();
	}

	@Test
	public void testFirst() throws Exception {
		RequestBuilder req = get("/first/get/1");
		mockMvc.perform(req).andExpect(status().isOk()).andExpect(content().string("hello world"));
	}

	@Test
	public void testSay() throws Exception {
		RequestBuilder request = get("/first/say").param("name", "xudong.li");
		mockMvc.perform(request).andExpect(status().isOk())
				.andExpect(content().string("{\"name\":\"xudong.li\",\"title\":\"hello world\"}"));
	}

}
