package com.wymessi.activemq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer2 {
//    @JmsListener(destination = "publish.queue")
    public void receiveQueue(String consumer) {
        System.out.println(consumer+"消息已经消费了 BY QUEUE 消费者2");
    }
}
