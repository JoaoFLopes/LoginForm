package org.academiadecodigo.mavenlogin.service.user;

import org.academiadecodigo.mavenlogin.model.User;
import org.academiadecodigo.mavenlogin.service.Service;

/**
 * Created by codecadet on 15/11/16.
 */
public interface UserService extends Service{

    void add(User user);

    boolean authenticate(String username, String password);

    User findByName(String username);

    int count();

    @Override
    String getName();
}
