//package com.mycompany.app;
//
//import com.google.common.cache.CacheBuilderSpec;
//import com.google.gson.JsonArray;
//import com.google.gson.JsonElement;
//import com.google.gson.JsonObject;
//import com.google.gson.stream.JsonReader;
//import com.mycompany.app.dto.NewSmsDto;
//import com.mycompany.app.utils.AfricaTalkingUtil;
//import com.mysql.cj.xdevapi.JsonValue;
//import com.rabbitmq.client.Channel;
//import com.rabbitmq.client.Connection;
//import com.rabbitmq.client.ConnectionFactory;
//
//import java.io.*;
//import java.util.Iterator;
//import java.util.List;
//import java.util.concurrent.TimeoutException;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.InputStream;
//
//
//public class sender {
//    public static void main(String[] args) throws FileNotFoundException {
//        ConnectionFactory factory = new ConnectionFactory();
//        factory.setUsername("root");
//        factory.setPassword("password");
//        factory.setVirtualHost("/");
//        factory.setHost("localhost");
//        factory.setPort(5672);
//        List<NewSmsDto> newSmsDtoList = new DbManager().getNewSmses();
//
//
//
//
//        try (Connection connection = factory.newConnection()) {
//            Channel channel = connection.createChannel();
//            channel.queueDeclare("test", false, false, false, null);
//            System.out.println("Queue size = " + newSmsDtoList.size());
//            newSmsDtoList.parallelStream().forEach(x -> {
//                try {
//                    channel.basicPublish("", "test", false, null, x.toString().getBytes());
//                    System.out.println(x.toString());
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            });
//            System.out.println("done");
//
//
//        } catch (IOException | TimeoutException e) {
//            e.printStackTrace();
//        }
//
//
//    }
//}
