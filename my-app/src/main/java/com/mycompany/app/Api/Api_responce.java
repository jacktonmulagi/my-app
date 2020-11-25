package com.mycompany.app.Api;

import com.africastalking.Callback;
import com.africastalking.SmsService;
import com.africastalking.sms.Message;
import com.africastalking.sms.Recipient;
import com.africastalking.AfricasTalking;

import java.util.List;
import java.io.IOException;

public class Api_responce
{
    public static void main(String[] args)
    {
        /* Set your app credentials */
        String USERNAME = "sandbox";
        String API_KEY = "03d7f2ed3f9c233037b5c979784bb8cbf6ccf245b0eea94e7f3fee36bfea236c";

        /* Initialize SDK */
        AfricasTalking.initialize(USERNAME, API_KEY);

        /* Get the SMS service */
        SmsService sms = AfricasTalking.getService(AfricasTalking.SERVICE_SMS);

        /*
            Our API will return 100 messages at a time back to you, starting with what you currently
            believe is the lastReceivedId. Specify 0 for the first time you access the method and
            the ID of the last message we sent you on subsequent calls
        */
        long lastReceivedId = 0;

        /* Fetch all messages using a loop */
        try {
            List<Message> messages;
            do {
                messages = sms.fetchMessages(lastReceivedId);
                for (Message message : messages) {
                    System.out.print(message.from);
                    System.out.print(" : ");
                    System.out.println(message.toString());

                    /* Reassign the lastReceivedId */
                    lastReceivedId = message.id;

                    /* NOTE: Be sure to save the lastReceivedId for next time */
                }
            } while(messages.size() > 0);
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}