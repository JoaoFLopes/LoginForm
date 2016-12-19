package org.academiadecodigo.mavenlogin.service.user;

import org.academiadecodigo.mavenlogin.model.User;
import org.academiadecodigo.mavenlogin.persistence.jdbc.ConnectionManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by codecadet on 28/11/16.
 */
public class jbdcUserService implements UserService {

    Connection dbConnection;

    public jbdcUserService(ConnectionManager manager){
        dbConnection = manager.getConnection();
    }

    @Override
    public void add(User user) {

        int affectRows;

        try {
            Statement statement = dbConnection.createStatement();

            String query = "INSERT INTO users (username, password, email) VALUES " +
                    "(\'" + user.getUsername() + "\', " +
                    "\'" + user.getPassword() + "\', " +
                    "\'" + user.getEmail() + "\')";

            affectRows = statement.executeUpdate(query);

            System.out.println("Updated rows: " + affectRows);

            if(statement != null)
                statement.close();

        } catch (SQLException e) {
            System.out.println("Failed to add user: " + e.getMessage());
        }

    }

    @Override
    public boolean authenticate(String username, String password) {

        User currentUser = findByName(username);

        if(currentUser == null){
            return false;
        }

        if(currentUser.getPassword().equals(password)){
            System.out.println("Login Authorized");
            return true;
        }
        else {
            System.out.println("Wrong credentials");
            return false;
        }
    }

    @Override
    public User findByName(String username) {

        User user = null;

        try {
            Statement statement = dbConnection.createStatement();

            String query = "SELECT * FROM users WHERE username = \'" + username + "\'";

            ResultSet resultSet = statement.executeQuery(query);

            if(resultSet.next()){

                String name = resultSet.getString("username");
                String password = resultSet.getString("password");
                String email = resultSet.getString("email");

                user = new User();

                user.setUsername(name);
                user.setEmail(email);
                user.setPassword(password);
            }


            if(statement != null)
                statement.close();



        } catch (SQLException e) {
            System.out.println("Failed to find user: " + e.getMessage());
        }

        return user;

    }

    @Override
    public int count() {

        int result = 0;

        try {
            Statement statement = dbConnection.createStatement();

            String query = "SELECT COUNT(*) FROM users";

            ResultSet resultSet = statement.executeQuery(query);

            if(resultSet.next()){
                result = resultSet.getInt(1);
            }

            if(statement != null)
                statement.close();

        } catch (SQLException e) {
            System.out.println("Failed to count users: " + e.getMessage());
        }

        return result;

    }

    @Override
    public String getName() {
        return "jdbc";
    }
}
