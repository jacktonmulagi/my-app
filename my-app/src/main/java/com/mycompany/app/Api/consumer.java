package com.mycompany.app.Api;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class consumer {

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername("root");
        factory.setPassword("password");
        factory.setVirtualHost("/");
        factory.setHost("localhost");
        factory.setPort(5672);

        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
//        channel.exchangeDeclare("logs", "fanout");
        channel.queueDeclare("test1", false, false, false, null);
//        channel.queueBind("test", "", "");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String m[] = new String(delivery.getBody(), "UTF-8").split("#");
            System.out.println("linkId " + m[0] + ", Text " + m[1]+" ,to " + m[2] + ", id " + m[3]+",date " + m[4] + ", from " + m[5]);
            save_into_db.save(m[0], m[1],m[2], m[3],m[4], m[5]);

        };
        channel.basicConsume("test1", true, deliverCallback, consumerTag -> { });


    }

//    private static void doWork(String task) {
//        for (char ch : task.toCharArray()) {
//            if (ch == '.') {
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException _ignored) {
//                    Thread.currentThread().interrupt();
//                }
//            }
//        }
//    }
}
