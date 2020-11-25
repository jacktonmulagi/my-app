////
//// Source code recreated from a .class file by IntelliJ IDEA
//// (powered by FernFlower decompiler)
////
//
//package com.mycompany.app.utils;
//
//import com.africastalking.AfricasTalking;
//import com.africastalking.SmsService;
//import com.africastalking.sms.Recipient;
//import java.io.IOException;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.util.Calendar;
//import java.util.Iterator;
//import java.util.List;
//import com.mycompany.app.EnvSettings;
//
//public class AfricaTalkingUtil {
//    private SmsService smsService;
//
//    public AfricaTalkingUtil() throws IOException {
//        AfricasTalking.initialize(EnvSettings.getInstance().getApiUsername(), EnvSettings.getInstance().getApiKey());
//        if (this.smsService == null) {
//            this.smsService = (SmsService)AfricasTalking.getService(AfricasTalking.SERVICE_SMS);
//        }
//
//    }
//
//
//
//    public static AfricaTalkingUtil getInstance() {
//        ;
//    }
////
//    public static void sendSMS(String phone, String text) {
//        List response = null;
//        try
//        {
//            // create a mysql database connection
//            String myDriver = "org.gjt.mm.mysql.Driver";
//            String myUrl = "jdbc:mysql://localhost/test";
//            Class.forName(myDriver);
//            Connection conn = DriverManager.getConnection(myUrl, "root", "");
//
//            // create a sql date object so we can use it in our INSERT statement
//            Calendar calendar = Calendar.getInstance();
//            java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());
//
//            // the mysql insert statement
//            String query = " insert into users (first_name, last_name, date_created, is_admin, num_points)"
//                    + " values (?, ?, ?, ?, ?)";
//
//            // create the mysql insert preparedstatement
//            PreparedStatement preparedStmt = conn.prepareStatement(query);
//            preparedStmt.setString (1, "Barney");
//            preparedStmt.setString (2, "Rubble");
//            preparedStmt.setDate   (3, startDate);
//            preparedStmt.setBoolean(4, false);
//            preparedStmt.setInt    (5, 5000);
//
//            // execute the preparedstatement
//            preparedStmt.execute();
//
//            conn.close();
//        }
//        catch (Exception e)
//        {
//            System.err.println("Got an exception!");
//            System.err.println(e.getMessage());
//        }
//    }
//
//
//        }
//
//
//
//
//
