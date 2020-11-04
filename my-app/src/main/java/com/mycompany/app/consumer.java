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
            channel.queueDeclare("testing",false,false,false,null);
            channel.basicConsume("testing",true,(consumerTag,message)->{String M = new  String((message.getBody() ), "UTF-8");
                List<NewSmsDto> newSmsDtoList = (new DbManager()).getNewSmses();
                Iterator var2 = newSmsDtoList.iterator();

                while(var2.hasNext()) {
                    NewSmsDto sms = (NewSmsDto)var2.next();
                    AfricaTalkingUtil.getInstance().sendSMS(sms.getPhone(), M);
                    new DbManager();}

            System.out.println("i JUST RECEIVED A MESSAGE=" +M);
    },consumerTag ->{}
        );
            String message = "welcome home";
            channel.basicPublish("", "testing",false,null,message.getBytes());
            System.out.println("done");



        }

    }


