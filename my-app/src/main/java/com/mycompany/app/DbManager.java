//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.mycompany.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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

    public List<NewSmsDto> getNewSmses() {
        ArrayList newSmsDtoList = new ArrayList();

        Connection connection;
        String sql;
        PreparedStatement pstmt;
        try {
            connection = this.getConnection();

            try {
                sql = "SELECT o.contect, p.phone_number FROM Sms o, Clients p  WHERE p.category = o.category  AND o.status =?";
                pstmt = connection.prepareStatement(sql);
                pstmt.setString(1, "success");
                ResultSet rs = pstmt.executeQuery();

                while(rs.next()) {
                    newSmsDtoList.add(new NewSmsDto(rs.getString("phone_number"), rs.getString("contect")));
                }
            } catch (Throwable var10) {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (Throwable var7) {
                        var10.addSuppressed(var7);
                    }
                }

                throw var10;
            }

            if (connection != null) {
                connection.close();
            }
        } catch (Exception var11) {
            var11.printStackTrace();
        }

        try {
            connection = this.getConnection();

            try {
                sql = "update Sms SET Status ='success' WHERE Status ='pending'";
                pstmt = connection.prepareStatement(sql);
                System.out.println("updating....");
                pstmt.executeUpdate();
            } catch (Throwable var8) {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (Throwable var6) {
                        var8.addSuppressed(var6);
                    }
                }

                throw var8;
            }

            if (connection != null) {
                connection.close();
            }
        } catch (Exception var9) {
            var9.printStackTrace();
        }

        return newSmsDtoList;
    }
}
