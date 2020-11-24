package com.mycompany.app;

import com.mycompany.app.dto.NewSmsDto;
import com.mycompany.app.utils.AfricaTalkingUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeoutException;

public class sender {
    public static void main(String[] args) {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername("root");
        factory.setPassword("password");
        factory.setVirtualHost("/");
        factory.setHost("localhost");
        factory.setPort(5672);
        List<NewSmsDto> newSmsDtoList = new DbManager().getNewSmses();
        try (Connection connection = factory.newConnection()) {
            Channel channel = connection.createChannel();
            channel.queueDeclare("test", false, false, false, null);
            System.out.println("Queue size = " + newSmsDtoList.size());
            newSmsDtoList.parallelStream().forEach(x -> {
                try {
                    channel.basicPublish("", "test", false, null, x.toString().getBytes());
                    System.out.println(x.toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            System.out.println("done");


        } catch (IOException | TimeoutException e) {
            e.printStackTrace();
        }


    }
}
