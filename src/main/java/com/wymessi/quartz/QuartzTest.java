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
		JobDetail job = JobBuilder.newJob(HelloJob.class).withIdentity("myJob1", "group1").usingJobData("value", "我是value1").build();

		// Trigger the job to run now, and then every 2 seconds
		Trigger trigger = TriggerBuilder.newTrigger().withIdentity("myTrigger1", "group1").startNow()
				.withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).repeatForever()).build();

		sched.scheduleJob(job, trigger);

		JobDetail job2 = JobBuilder.newJob(HelloJob.class).withIdentity("myJob2", "group2").usingJobData("value", "我是value2").build();

		// Trigger the job to run now, and then every 2 seconds
		Trigger trigger2 = TriggerBuilder.newTrigger().withIdentity("myTrigger2", "group2").startNow()
				.withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(10).repeatForever()).build();

		// Tell quartz to schedule the job using our trigger
		sched.scheduleJob(job2, trigger2);
	}

}
