package com.petpals.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbConnectionsUtil {
	 static Connection connection;

    public static Connection getConnection() {
        Properties properties = DbPropertiesUtil.getProperties();
        String url=properties.getProperty("db.url");
    	String username=properties.getProperty("db.username");
    	String password=properties.getProperty("db.password");
    	try {
    		connection=DriverManager.getConnection(url,username,password);
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    	return connection;   	
}
}