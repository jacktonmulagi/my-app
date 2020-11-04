//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.mycompany.app.utils;

import com.africastalking.AfricasTalking;
import com.africastalking.SmsService;
import com.africastalking.sms.Recipient;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import com.mycompany.app.EnvSettings;

public class AfricaTalkingUtil {
    private SmsService smsService;

    public AfricaTalkingUtil() {
        AfricasTalking.initialize(EnvSettings.getInstance().getApiUsername(), EnvSettings.getInstance().getApiKey());
        if (this.smsService == null) {
            this.smsService = (SmsService)AfricasTalking.getService(AfricasTalking.SERVICE_SMS);
        }

    }

    public static AfricaTalkingUtil getInstance() {
        return AfricaTalkingUtil.LazyHolder.instance;
    }

    public void sendSMS(String phone, String text) {
        List response = null;

        try {
            response = this.smsService.send(text, new String[]{phone}, true);
            Iterator var4 = response.iterator();

            while(var4.hasNext()) {
                Recipient recipient = (Recipient)var4.next();
                System.out.print(recipient.number);
                System.out.print(" : ");
                System.out.println(recipient.status);
                System.out.println(recipient.cost);
                System.out.println(recipient.messageId);
            }
        } catch (IOException var6) {
            var6.printStackTrace();
        }

    }

    private static class LazyHolder {
        private static final AfricaTalkingUtil instance = new AfricaTalkingUtil();

        private LazyHolder() {
        }
    }
}
