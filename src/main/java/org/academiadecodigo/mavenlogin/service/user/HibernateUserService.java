package org.academiadecodigo.mavenlogin.service.user;

import org.academiadecodigo.mavenlogin.model.User;
import org.academiadecodigo.mavenlogin.persistence.hibernate.HibernateSessionManager;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 * Created by codecadet on 01/12/16.
 */
public class HibernateUserService implements UserService {

    public HibernateUserService(){

    }

    @Override
    public void add(User user) {

        try{
            Session s = HibernateSessionManager.beginTransaction();

            s.save(user);

            HibernateSessionManager.commitTransaction();
        } catch (HibernateException ex){
            HibernateSessionManager.rollbackTransaction();
            ex.printStackTrace();
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

        try{
            Session s = HibernateSessionManager.beginTransaction();

            Query query = s.createQuery("FROM User where username = :username");
            query.setString("username", username);

            user = (User)query.uniqueResult();

            if(user != null)
                HibernateSessionManager.commitTransaction();
            else
                HibernateSessionManager.rollbackTransaction();
        } catch (HibernateException ex){
            HibernateSessionManager.rollbackTransaction();
            ex.printStackTrace();
        }

        return user;
    }

    @Override
    public int count() {

        int numberOfUsers = 0;

        try{
            Session s = HibernateSessionManager.beginTransaction();

            Query query = s.createQuery("SELECT COUNT (*) FROM User");
            numberOfUsers = ((Long)query.uniqueResult()).intValue();

            HibernateSessionManager.commitTransaction();
        } catch (HibernateException ex){
            ex.printStackTrace();
            HibernateSessionManager.rollbackTransaction();
        } finally {

        }

        return numberOfUsers;
    }

    @Override
    public String getName() {
        return "hibernate";
    }
}
