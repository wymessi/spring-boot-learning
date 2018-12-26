package com.wymessi.schedule;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * springboot自带的定时任务
 * 当应用启动后，定时任务开启
 * @author 王冶
 *
 */
@Component
@Async //开启任务异步执行，多线程执行任务
public class SchedulerTask {

	private static final Logger logger = LogManager.getLogger(SchedulerTask.class);
	
//	@Scheduled(fixedRate=2000) //每六秒执行一次
	@Scheduled(cron = "0 0/1 * * * ? ")
	public void task(){
		logger.info("定时任务-现在时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
	}
}
