package com.mycompany.app.Api;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class producer
{
    @SuppressWarnings("unchecked")

    public static void main(String[] args)
    {
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("/home/jmulagi/IdeaProjects/rabbit/my-app/src/main/java/com/mycompany/app/Api/results.json"))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONArray employeeList = (JSONArray) obj;
            System.out.println(employeeList);

            //Iterate over employee array
            employeeList.forEach( emp -> parseEmployeeObject( (JSONObject) emp ) );



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private static void parseEmployeeObject(JSONObject employee)
    {


        //Get employee object within list
        JSONObject employeeObject = (JSONObject) employee.get("message");

        //Get employee first name
        String linkId = (String) employeeObject.get("linkId");
        System.out.println(linkId);

        //Get employee last name
        String text = (String) employeeObject.get("text");
        System.out.println(text);

        //Get employee website name
        String to = (String) employeeObject.get("to");
        System.out.println(to);

        //Get employee first name
        String id = (String) employeeObject.get("id");
        System.out.println(id);

        //Get employee last name
        String date = (String) employeeObject.get("date");
        System.out.println(date);

        //Get employee website name
        String from = (String) employeeObject.get("from");
        System.out.println(from);
        String message = linkId +'#'+text+'#'+to +'#'+id+'#'+date +'#'+from;
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername("root");
        factory.setPassword("password");
        factory.setVirtualHost("/");
        factory.setHost("localhost");
        factory.setPort(5672);

        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.queueDeclare("test1", false, false, false, null);

            int i=1;
            while(i<10000)
            {
                channel.basicPublish("", "test1", null, message.getBytes(StandardCharsets.UTF_8));
                System.out.println(" [x] Sent '" + message + "'");
                System.out.println(i);
                i++;
            }
//            channel.basicPublish("", "test1", null, message.getBytes(StandardCharsets.UTF_8));
//            System.out.println(" [x] Sent '" + message + "'");
        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
