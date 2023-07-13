package com.atguigu.consumer;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.annotation.RabbitListeners;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

    @RabbitListeners({
            @RabbitListener(queues = "spring_boot_simple_queue",ackMode = "AUTO"),
            @RabbitListener(queues = "spring_boot_fanout_queue01",ackMode = "AUTO"),
            @RabbitListener(queues = "spring_boot_direct_queue01",ackMode = "AUTO"),
            @RabbitListener(queues = "spring_boot_topic_queue01",ackMode = "AUTO")
    })
    public void consumeFanoutQueue01(Message message){
        System.out.println("01消息：" + new String(message.getBody()));
    }

    @RabbitListeners({
            @RabbitListener(queues = "spring_boot_simple_queue",ackMode = "AUTO"),
            @RabbitListener(queues = "spring_boot_fanout_queue02",ackMode = "AUTO"),
            @RabbitListener(queues = "spring_boot_direct_queue02",ackMode = "AUTO"),
            @RabbitListener(queues = "spring_boot_topic_queue02",ackMode = "AUTO")
    })
    public void consumeFanoutQueue02(Message message){
        System.out.println("02消息：" + new String(message.getBody()));
    }
}
