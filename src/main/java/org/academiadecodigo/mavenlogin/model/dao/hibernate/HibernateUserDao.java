package org.academiadecodigo.mavenlogin.model.dao.hibernate;

import com.sun.xml.internal.ws.handler.HandlerException;
import org.academiadecodigo.mavenlogin.model.User;
import org.academiadecodigo.mavenlogin.model.dao.UserDao;
import org.academiadecodigo.mavenlogin.persistence.TransactionException;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 * Created by codecadet on 01/12/16.
 */
public class HibernateUserDao extends HibernateDao<User> implements UserDao {


    public HibernateUserDao() {
        super(User.class);
    }

    @Override
    public User findByName(String username) {

        User user = null;

        try {
            System.out.println("finding by name: " + username);
            Session session = getHibernateSessionManager().getSession();
            Query query = session.createQuery("FROM User WHERE username = :username");

            query.setString("username", username);

            user = (User) query.uniqueResult();

            System.out.println("found " + user);
        }catch (HandlerException ex){
            throw new TransactionException(ex);
        }
        return user;
    }
}
