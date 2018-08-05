package com.wymessi.quartz;

import java.util.ArrayList;
import java.util.Date;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;

/**
 * 第一个job
 * 
 * @author wangye
 *
 */
public class HelloJob implements Job {

	private static final Logger logger = LogManager.getLogger(HelloJob.class);

	String value;

	public void setValue(String value) {
		this.value = value;
	}

	public HelloJob() {
		super();
	}

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		JobKey key = context.getJobDetail().getKey();

		JobDataMap dataMap = context.getMergedJobDataMap(); // Note the
															// difference from
		logger.info(key + "====" + value);
	}

}
