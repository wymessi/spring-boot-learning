package com.wymessi.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * 针对spring boot自带定时任务的配置
 * 配置任务异步执行，在不同的线程中执行
 * @author 王冶
 *
 */
@Configuration
@EnableAsync
public class AsyncConfig {

	@Value("${corePoolSize}")
	private int corePoolSize;
	
	@Value("${maxPoolSize}")
    private int maxPoolSize;
	
	@Value("${queueCapacity}")
    private int queueCapacity;
    
    @Bean
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setQueueCapacity(queueCapacity);
        executor.initialize();
        return executor;
    }
}
