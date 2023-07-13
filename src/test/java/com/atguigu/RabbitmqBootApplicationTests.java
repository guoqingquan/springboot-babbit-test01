package com.atguigu;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RabbitmqBootApplicationTests {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void testSimpleProducer(){
        for(int i = 0;i <= 100;i++){
            String message = "hello springboot simple rabbitmq" + i;
            rabbitTemplate.convertAndSend("spring_boot_simple_queue",message);
        }
    }

    @Test
    public void testFanoutProducer(){
        rabbitTemplate.convertAndSend("spring_boot_fanout_exchange","","hello springboot fanout rabbitmq");
    }

    @Test
    public void testDirectProducer(){
        rabbitTemplate.convertAndSend("spring_boot_direct_exchange","info","hello springboot direct rabbitmq");
        rabbitTemplate.convertAndSend("spring_boot_direct_exchange","debug","hello springboot direct rabbitmq");
    }

    @Test
    public void testTopicProducer(){
        rabbitTemplate.convertAndSend("spring_boot_topic_exchange","atguigu.info","hello springboot topic rabbitmq");
        rabbitTemplate.convertAndSend("spring_boot_topic_exchange","atguigu.debug","hello springboot topic rabbitmq");
    }
}
