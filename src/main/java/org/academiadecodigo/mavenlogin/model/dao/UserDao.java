package org.academiadecodigo.mavenlogin.model.dao;

import org.academiadecodigo.mavenlogin.model.User;

import java.util.List;

/**
 * Created by codecadet on 01/12/16.
 */
public interface UserDao extends Dao<User> {

   User findByName(String username);
}
