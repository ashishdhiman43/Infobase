package com.appsquadz;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class DBUtility {
	private static Connection connection = null;

    public static Connection getConnection() {
        if (connection != null)
            return connection;
        else {
            try {
            	//Properties prop = new Properties();
               // InputStream inputStream = DBUtility.class.getClassLoader().getResourceAsStream("/com/config.properties");
               // prop.load(inputStream);
              //  String driver = prop.getProperty("driver");
                //String url = prop.getProperty("url");
               // String user = prop.getProperty("user");
              //  String password = prop.getProperty("password");
               Class.forName("oracle.jdbc.driver.OracleDriver");
                connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
            } catch (Exception e) {
                e.printStackTrace();
            } 
            return connection;
        }

    }

}