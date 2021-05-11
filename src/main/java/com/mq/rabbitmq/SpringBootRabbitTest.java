package com.mq.rabbitmq;

import com.example.spring.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = Application.class)
@RunWith((SpringRunner.class))
public class SpringBootRabbitTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void test001() {
        rabbitTemplate.convertAndSend("logs","","广播消息");
    }

}
