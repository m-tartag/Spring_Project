package com.scraper;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnector {

    public static Connection getConnection() throws Exception{
        try{
            String driver = "com.mysql.jdbc.Driver";
            String url = "";
            String username = "";
            String password = "";
            Class.forName(driver);

            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connected");
            return conn;
            } catch(Exception e){System.out.println(e);

            return null;
        }
    }
}
