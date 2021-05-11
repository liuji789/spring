package com.mq.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * @author admin
 * exchange给指定的routingKey发消息
 */
public class DirectProvider {

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

        //direct使用 声明交换机
        channel.exchangeDeclare("logs_direct","direct");
        //发布消息
        String key = "";
        channel.basicPublish("logs_direct",key,null,("hello,key"+key+"").getBytes());

        channel.close();
        connection.close();
    }

}
