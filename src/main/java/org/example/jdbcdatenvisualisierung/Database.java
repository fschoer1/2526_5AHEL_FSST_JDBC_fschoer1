package org.example.jdbcdatenvisualisierung;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class Database {

    public static Connection connect() throws Exception {

        String url = "jdbc:postgresql://xserv:5432/world2";

        Properties props = new Properties();
        props.setProperty("user", "reader");
        props.setProperty("password", "reader");

        return DriverManager.getConnection(url, props);
    }
}
