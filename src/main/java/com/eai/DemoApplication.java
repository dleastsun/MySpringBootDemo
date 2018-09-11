package com.eai;

import java.util.HashSet;
import java.util.Set;

import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.eai.common.utils.SpringContextUtil;

//@EnableBatchProcessing
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
		Set<Object> set = new HashSet<>();
		set.add("classpath:batch-config.xml");
		set.add("classpath:quartz-config.xml");
		set.add("applicationContext.xml");
		SpringApplication app = new SpringApplication(DemoApplication.class);
		app.setSources(set);
		ApplicationContext context = app.run(args);
		SpringContextUtil.setApplicationContext(context);
	}
}
