package com.wymessi.activemq;

import org.apache.activemq.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.messaging.converter.MessageConverter;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    /*@Autowired
    private MessageConverter converter;*/

    @Autowired
    private JmsTemplate jms;


//    @JmsListener(destination = "publish.queue", containerFactory = "jmsListenerContainerQueue")
//    public void receiveQueue(String consumer) {
//        System.out.println(consumer+"消息已经消费了 BY QUEUE");
//    }

    @JmsListener(destination = "publish.topic", containerFactory = "jmsListenerContainerTopic")
    public void receiveTopic(User s) {
//        User s = (User)converter.fromMessage(message, User.class);
        System.out.println(s.getName()+" :消息已经消费了 BY TOPIC");
    }

}
