//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.mycompany.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class config {
    final String DRIVER = "com.mysql.jdbc.Driver";
    final String DB_PATH = "jdbc:mysql://localhost/survey ";
    String userName = null;
    String password = null;
    Connection conn = null;
    Statement stmt = null;

    public config(String name, String pass) {
        this.userName = name;
        this.password = pass;
    }

    public void connect() throws SQLException, Exception {
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("connecting....");
        this.conn = DriverManager.getConnection("jdbc:mysql://localhost/survey ", this.userName, this.password);
        this.stmt = this.conn.createStatement();
    }

    public void closeConnection() throws SQLException, Exception {
        this.stmt.close();
        this.conn.close();
    }

    public Statement getStatement() {
        return this.stmt;
    }

    public Connection getConnection() {
        return this.conn;
    }
}
