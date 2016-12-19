package org.academiadecodigo.mavenlogin.service.user;

import org.academiadecodigo.mavenlogin.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by codecadet on 15/11/16.
 */
public class MockUserService implements UserService {

    List<User> userList;

    MockUserService(){
        userList = new ArrayList<>();
    }

    @Override
    public void add(User user) {
        userList.add(user);
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

        if(userList.isEmpty())
            return null;

        for (int i = 0; i < userList.size(); i++) {
            if(userList.get(i).getUsername().equals(username)) {
                System.out.println("user found");
                return userList.get(i);
            }
        }

        System.out.println("User not found");
        return null;
    }

    @Override
    public int count() {
        return userList.size();
    }

    @Override
    public String getName() {
        return "mock";
    }
}
