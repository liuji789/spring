package com.mq.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

/**
 * @author qingn
 */
public class Provider {

    public static void main(String[] args) throws Exception {
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
        //参数1: 是否持久化  参数2:是否独占队列 参数3:是否自动删除  参数4:其他属性
        //'参数1':用来声明通道对应的队列
        //'参数2':用来指定是否持久化队列 D
        //'参数3':用来指定是否独占队列
        //'参数4':用来指定是否自动删除队列 AD
        //'参数5':对队列的额外配置
        channel.queueDeclare("hello", true, false, false, null);
        channel.basicPublish("", "hello", MessageProperties.PERSISTENT_TEXT_PLAIN, "hello rabbitmq".getBytes());
        channel.close();
        connection.close();

    }

}
