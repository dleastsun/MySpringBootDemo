package com.eai.common.config;

import javax.jms.Queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * jms 队列配置
 * 
 * @author xudong.li
 */
@Configuration
public class JmsConfiguration {

	@Bean
	public Queue queue() {
		return new ActiveMQQueue("my.queue");
	}

}

