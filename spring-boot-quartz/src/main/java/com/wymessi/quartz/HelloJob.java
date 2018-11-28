package com.wymessi.quartz;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.*;

import java.util.Arrays;

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
		System.out.println(Arrays.asList(dataMap.getKeys()));

		logger.info(key + "====" + value);
	}

}
