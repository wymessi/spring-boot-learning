package com.wymessi.activemq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
    @JmsListener(destination = "publish.queue")
    public void receiveQueue(String consumer) {
        System.out.println(consumer+"消息已经消费了 BY QUEUE");
    }

    @JmsListener(destination = "publish.topic", containerFactory = "jmsListenerContainerTopic")
    public void receiveTopic(String consumer) {
        System.out.println(consumer+"消息已经消费了 BY TOPIC");
    }

}
