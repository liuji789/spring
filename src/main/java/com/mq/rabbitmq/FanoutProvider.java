package com.mq.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * @author admin
 * 广播，每一个消费者都有一个自己的queue，exchange发给各自的queue。
 * routingKey 不起作用
 */
public class FanoutProvider {

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

        //fanout使用 声明交换机
        channel.exchangeDeclare("logs","fanout");
        //发布消息
        channel.basicPublish("logs","",null,"hello".getBytes());

        channel.close();
        connection.close();
    }

}
