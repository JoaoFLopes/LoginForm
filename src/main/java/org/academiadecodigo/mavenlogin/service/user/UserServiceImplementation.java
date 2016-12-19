package org.academiadecodigo.mavenlogin.service.user;

import org.academiadecodigo.mavenlogin.model.User;
import org.academiadecodigo.mavenlogin.model.dao.hibernate.HibernateRoleDao;
import org.academiadecodigo.mavenlogin.model.dao.hibernate.HibernateUserDao;
import org.academiadecodigo.mavenlogin.persistence.hibernate.HibernateTransactionManager;

/**
 * Created by codecadet on 07/12/16.
 */
public class UserServiceImplementation implements UserService {


    HibernateRoleDao roleDao;
    HibernateUserDao userDao;
    HibernateTransactionManager transactionManager;

    public UserServiceImplementation(HibernateRoleDao roleDao, HibernateUserDao userDao, HibernateTransactionManager transactionManager) {
        this.roleDao = roleDao;
        this.userDao = userDao;
        this.transactionManager = transactionManager;
    }

    @Override
    public void add(User user) {

    }

    @Override
    public boolean authenticate(String username, String password) {
        return false;
    }

    @Override
    public User findByName(String username) {
        return null;
    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public String getName() {
        return "spring";
    }

    public HibernateRoleDao getRoleDao() {
        return roleDao;
    }

    public void setRoleDao(HibernateRoleDao roleDao) {
        this.roleDao = roleDao;
    }

    public HibernateUserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(HibernateUserDao userDao) {
        this.userDao = userDao;
    }

    public HibernateTransactionManager getTransactionManager() {
        return transactionManager;
    }

    public void setTransactionManager(HibernateTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }
}
