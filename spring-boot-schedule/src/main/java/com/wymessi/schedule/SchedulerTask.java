package com.wymessi.schedule;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * springboot自带的定时任务
 * 当应用启动后，定时任务开启
 * @author 王冶
 *
 */
@Component
//@Async //开启任务异步执行，多线程执行任务
public class SchedulerTask {

	private static final Logger logger = LogManager.getLogger(SchedulerTask.class);

	AtomicInteger atomicInteger = new AtomicInteger(1);

	/**
	 * 按照指定频率执行任务，并以此规则开始周期性的执行调度。
	 *
	 * 例如：fixedRateTask()方法在第0秒开始执行，方法执行了12秒，那么下一次执行fixedRateTask()方法的时间是第12秒。。
	 * @throws Exception
	 */
	@Scheduled(fixedRate=2000) //每两秒执行一次
	public void fixedRateTask() throws Exception{
		int i = atomicInteger.get();
		if (i < 5) {
			Thread.sleep(i * 1000);
		}
		atomicInteger.getAndIncrement();
		logger.info("fixedRate 定时类型");
	}

	@Scheduled(cron = "*/2 * * * * ? ")
	public void cronTask() throws Exception{
		int i = atomicInteger.get();
		if (i < 5) {
			Thread.sleep(i * 1000);
		}
		atomicInteger.getAndIncrement();
		logger.info("cron 定时类型");
	}


	/**
	 * 下一次的任务执行时间，是从方法最后一次任务执行结束时间开始计算。并以此规则开始周期性的执行任务。
	 *
	 * 例如：fixdelaytask()方法在第0秒开始执行，方法执行了12秒，那么下一次执行work()方法的时间是第14秒。
	 * @throws Exception
	 */
	@Scheduled(fixedDelay = 2000)
	public void fixdelayTask() throws Exception{
		int i = atomicInteger.get();
		if (i < 5) {
			Thread.sleep(i * 1000);
		}
		atomicInteger.getAndIncrement();
		logger.info("fixedDelay 定时类型");
	}
}
