package com.atguigu.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitmqConfiguration {

    @Bean
    public Queue simpleQueue(){
        return new Queue("spring_boot_simple_queue",true,false,false);
    }

    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange("spring_boot_fanout_exchange",true,false);
    }

    @Bean
    public Queue fanoutQueue01(){
        return new Queue("spring_boot_fanout_queue01",true,false,false);
    }

    @Bean
    public Queue fanoutQueue02(){
        return new Queue("spring_boot_fanout_queue02",true,false,false);    }

    @Bean
    public Binding fanoutBinding01(){
        return new Binding("spring_boot_fanout_queue01",Binding.DestinationType.QUEUE,"spring_boot_fanout_exchange","",null);
    }

    @Bean
    public Binding fanoutBinding02(){
        return new Binding("spring_boot_fanout_queue02",Binding.DestinationType.QUEUE,"spring_boot_fanout_exchange","",null);
    }

    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange("spring_boot_direct_exchange",true,false);
    }

    @Bean
    public Queue directQueue01(){
        return new Queue("spring_boot_direct_queue01",true,false,false);
    }

    @Bean
    public Queue directQueue02(){
        return new Queue("spring_boot_direct_queue02",true,false,false);
    }

    @Bean
    public Binding directBinding01(){
        return new Binding("spring_boot_direct_queue01",Binding.DestinationType.QUEUE,"spring_boot_direct_exchange","info",null);
    }

    @Bean
    public Binding directBinding02(){
        return new Binding("spring_boot_direct_queue02",Binding.DestinationType.QUEUE,"spring_boot_direct_exchange","debug",null);
    }

    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange("spring_boot_topic_exchange",true,false);
    }

    @Bean
    public Queue topicQueue01(){
        return new Queue("spring_boot_topic_queue01",true,false,false);
    }

    @Bean
    public Queue topicQueue02(){
        return new Queue("spring_boot_topic_queue02",true,false,false);
    }

    @Bean
    public Binding topicBinding01(){
        return new Binding("spring_boot_topic_queue01",Binding.DestinationType.QUEUE,"spring_boot_topic_exchange","#.info",null);
    }

    @Bean
    public Binding topicBinding02(){
        return new Binding("spring_boot_topic_queue02",Binding.DestinationType.QUEUE,"spring_boot_topic_exchange","#.debug",null);
    }
}
