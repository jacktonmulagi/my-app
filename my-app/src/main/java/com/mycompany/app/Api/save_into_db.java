package com.mycompany.app.Api;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower

import com.africastalking.AfricasTalking;
import com.africastalking.SmsService;
import com.africastalking.sms.Recipient;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import com.mycompany.app.EnvSettings;

public class save_into_db {
    private SmsService smsService;

    public save_into_db() throws IOException {
        AfricasTalking.initialize(EnvSettings.getInstance().getApiUsername(), EnvSettings.getInstance().getApiKey());
        if (this.smsService == null) {
            this.smsService = (SmsService)AfricasTalking.getService(AfricasTalking.SERVICE_SMS);
        }

    }

//    public static AfricaTalkingUtil getInstance() {
//    }

//    public static AfricaTalkingUtil getInstance() {
//        ;
//    }

    public static void save(String linkId, String text,String to, String id,String date, String from) {
        List response = null;
        try
        {
            // create a mysql database connection
            EnvSettings settings = EnvSettings.getInstance();
            System.out.println("connecting....");
            int var10000 = settings.getDbPort();

            String jdbcUrl = "jdbc:mysql://localhost:" + var10000 + "/" + settings.getDbName();

            Connection conn = DriverManager.getConnection(jdbcUrl, settings.getDbUsername(), settings.getDbPassword());

            // create a sql date object so we can use it in our INSERT statement

            // the mysql insert statement
            String query = " insert into inbox (linkId, text, keynumber, mess_id, date,client_phone)"
                    + " values (?, ?, ?, ?, ?,?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString (1, linkId);
            preparedStmt.setString (2, text);
            preparedStmt.setString (3, to);
            preparedStmt.setString (4, id);
            preparedStmt.setString (5, date);
            preparedStmt.setString (6, from);

            // execute the preparedstatement
            preparedStmt.execute();

            conn.close();
        }
        catch (Exception var11)
        {
            var11.printStackTrace();
        }
    }


}






