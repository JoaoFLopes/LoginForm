package org.academiadecodigo.mavenlogin.persistence.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by codecadet on 28/11/16.
 */
public class ConnectionManager {

    static Connection connection;

    public static Connection getConnection() {

        try {
            if (connection == null) {
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginDatabase", "root", "");
            }

        } catch (SQLException e) {
            System.out.println("Failure to connect to database : " + e.getMessage());
        }

        return connection;
    }


    public void close(){

        try{
            if(connection != null)
                System.out.println("Closing the DB");
                connection.close();
        } catch (SQLException e){
            System.out.println("Failure to close database connections: " + e.getMessage());
        }
    }
}
