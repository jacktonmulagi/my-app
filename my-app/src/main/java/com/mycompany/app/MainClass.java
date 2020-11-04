package com.mycompany.app;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

public class MainClass {
    public static void main(String[] args) throws IOException, TimeoutException {
        SmsSender sender = new SmsSender();
        sender.getAndSendSms();
    }
}

