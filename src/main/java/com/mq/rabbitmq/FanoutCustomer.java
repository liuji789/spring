package com.mq.rabbitmq;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

import java.io.IOException;

/**
 * @author admin
 */
public class FanoutCustomer {

    public static void main(String[] args) throws Exception{
        //创建连接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("10.231.63.137");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("longfor-member-sit");
        connectionFactory.setPassword("aQuBoYOUr9fxgs");
        connectionFactory.setVirtualHost("longfor-member-sit");
        Connection connection = connectionFactory.newConnection();
        //创建通道
        Channel channel = connection.createChannel();
        //绑定交换机
        channel.exchangeDeclare("logs","fanout");
        //创建临时队列
        String queue = channel.queueDeclare().getQueue();
        //将临时队列绑定到exchange
        channel.queueBind(queue,"logs","");
        //处理queue的消息
        channel.basicConsume(queue,true,new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String s = new String(body);
                System.out.println("消费者消费： " + s);
            }
        });

    }
}
