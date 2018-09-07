package com.eai.quartz;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.h2.util.New;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.configuration.JobLocator;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class QuartzJobLauncher extends QuartzJobBean {
/*-------------鏂瑰紡涓�锛氳幏鍙杍obName銆乯obLauncher鍜宩obLocator*/
//	private String jobName;
//	private JobLauncher jobLauncher;
//	private JobLocator jobLocator;
//
//	public String getJobName() {
//		return jobName;
//	}
//
//	public void setJobName(String jobName) {
//		this.jobName = jobName;
//	}
//
//	public JobLauncher getJobLauncher() {
//		return jobLauncher;  
//	}
//
//	public void setJobLauncher(JobLauncher jobLauncher) {
//		this.jobLauncher = jobLauncher;
//	}
//
//	public JobLocator getJobLocator() {
//		return jobLocator;
//	}
//
//	public void setJobLocator(JobLocator jobLocator) {
//		this.jobLocator = jobLocator;
//	}
/*------------------------鏂瑰紡涓�鑾峰彇缁撴潫------------------------------*/
	
	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
/*-------------鏂瑰紡浜岋細鑾峰彇jobName銆乯obLauncher鍜宩obLocator-------------------*/
		JobDetail jobDetail = context.getJobDetail();
		JobDataMap jobDataMap = jobDetail.getJobDataMap();
		String jobName = jobDataMap.getString("jobName");
		JobLauncher jobLauncher = (JobLauncher) jobDataMap.get("jobLauncher");
		JobLocator jobLocator = (JobLocator) jobDataMap.get("jobLocator");
		System.out.println("jobName : " + jobName);
		System.out.println("jobLauncher : " + jobLauncher);
		System.out.println("jobLocator : " + jobLocator);
/*-----------------------------鏂瑰紡浜岃幏鍙栫粨鏉�---------------------------------*/
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = sf.format(new Date());
		System.out.println("Current Time : " + date);
		
		try {
			Job job = jobLocator.getJob(jobName);
			JobExecution jobExecution = jobLauncher.run(job, new JobParametersBuilder().addDate("date", new Date()).toJobParameters());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
