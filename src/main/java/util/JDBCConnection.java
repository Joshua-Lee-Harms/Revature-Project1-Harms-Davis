package util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCConnection {

    // Singleton


    private static Connection conn = null;

    public static Connection getConnection() {

        // Credentials: url (endpoint), username, password

        if (conn == null) {
            //establish new connection

            Properties props = new Properties();
            try {

                props.load(JDBCConnection.class.getClassLoader().getResourceAsStream("connection.properties"));

                String endpoint = props.getProperty("endpoint");
                String url = "jdbc:postgresql://" + endpoint + "/postgres";
                String username = props.getProperty("username");
                String password = props.getProperty("password");

                conn = DriverManager.getConnection(url, username, password);

            } catch (IOException | SQLException e) {
                e.printStackTrace();
            }
        }
            return conn;
    }
}
