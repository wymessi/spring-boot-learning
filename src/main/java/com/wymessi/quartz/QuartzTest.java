package com.wymessi.quartz;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

/**
 * quartz 入门学习
 * 
 * @author wangye
 *
 */
public class QuartzTest {

	
	
	public static void main(String[] args) throws Exception{
		SchedulerFactory schedFact = new StdSchedulerFactory();

		Scheduler sched = schedFact.getScheduler();

		sched.start();

		// define the job and tie it to our HelloJob class
		JobDetail job = JobBuilder.newJob(HelloJob.class).withIdentity("myJob", "group1").usingJobData("value", "我是value").build();

		// Trigger the job to run now, and then every 2 seconds
		Trigger trigger = TriggerBuilder.newTrigger().withIdentity("myTrigger", "group1").startNow()
				.withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).repeatForever()).build();

		// Tell quartz to schedule the job using our trigger
		sched.scheduleJob(job, trigger);
	}

}
