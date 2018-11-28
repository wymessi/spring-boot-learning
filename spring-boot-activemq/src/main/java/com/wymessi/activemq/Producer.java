package com.wymessi.activemq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.Queue;
import javax.jms.Topic;

@Component
@Async //开启任务异步执行，多线程执行任务
public class Producer {
    @Autowired
    private JmsMessagingTemplate jms;

    @Autowired
    private Queue queue;

    @Autowired
    private Topic topic;

    @Scheduled(fixedRate=2000) //每两秒执行一次
    public void queue(){
        jms.convertAndSend(queue, "hello,activeMQ");
    }

    @Scheduled(fixedRate=2000) //每两秒执行一次
    public void topic(){
        jms.convertAndSend(topic, "hello,activeMQ");
    }
}
