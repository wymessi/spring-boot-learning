package com.wymessi.scheduler;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 当应用启动后，定时任务开启
 * @author 王冶
 *
 */
@Component
public class SchedulerTask {

	@Scheduled(fixedRate=6000) //每六秒执行一次
	public void task(){
		System.out.println("定时任务-现在时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
	}
}
