package com.mycompany.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mycompany.app.dto.NewSmsDto;

public class DbManager {
    public DbManager() {
    }


    private Connection getConnection() throws SQLException {
        EnvSettings settings = EnvSettings.getInstance();
        System.out.println("connecting....");
        int var10000 = settings.getDbPort();
        String jdbcUrl = "jdbc:mysql://localhost:" + var10000 + "/" + settings.getDbName();
        return DriverManager.getConnection(jdbcUrl, settings.getDbUsername(), settings.getDbPassword());
    }

    public ArrayList getNewSmses() {
        ArrayList newSmsDtoList = new ArrayList();
        try (Connection connection = this.getConnection()) {
            String sql = "SELECT o.contect, p.phone_number FROM Sms o, Clients p  WHERE p.category = o.category  AND o.status =?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, "pending");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                newSmsDtoList.add(new NewSmsDto(rs.getString("phone_number"), rs.getString("contect")));
            }

            sql = "update Sms SET Status ='success' WHERE Status ='pending'";
            connection.prepareStatement(sql);
        } catch (Exception var11) {
            var11.printStackTrace();
        }

        return newSmsDtoList;
    }
}
