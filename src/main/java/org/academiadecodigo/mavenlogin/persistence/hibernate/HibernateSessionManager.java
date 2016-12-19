package org.academiadecodigo.mavenlogin.persistence.hibernate;

/**
 * Created by codecadet on 01/12/16.
 */
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

public class HibernateSessionManager {

    private  SessionFactory sessionFactory;

    public HibernateSessionManager(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
/*        try {
           // Hold services needed by Hibernate
           ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                   .configure("hibernate.cfg.xml") // Load settings from org.academiadecodigo.mavenlogin.persistence.hibernate.cfg.xml
                   .build();

           sessionFactory = new MetadataSources(serviceRegistry)
                   .buildMetadata() // Tell Hibernate about sources of metadata (database mappings)
                   .buildSessionFactory();

       } catch (HibernateException ex) {
           throw new ExceptionInInitializerError("Error creating org.academiadecodigo.loginmvcmaven.Persistence.hibernate session factory: " + ex.getMessage());
       }*/
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
//        static {
//        try {
//            // Hold services needed by Hibernate
//            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
//                    .configure("hibernate.cfg.xml") // Load settings from org.academiadecodigo.lmavelogin.persistence.hibernate.cfg.xml
//                    .build();
//
//            sessionFactory = new MetadataSources(serviceRegistry)
//                    .buildMetadata() // Tell Hibernate about sources of metadata (database mappings)
//                    .buildSessionFactory();
//
//        } catch (HibernateException ex) {
//            throw new ExceptionInInitializerError("Error creating org.academiadecodigo.loginmvcmaven.Persistence.hibernate session factory: " + ex.getMessage());
//        }
//    }

    public  Session getSession() {
        // Hibernate will automatically open a new session if needed
        // Closing the session is not required
        return sessionFactory.getCurrentSession();
    }

    // Required to stop org.academiadecodigo.mavenlogin.persistence.hibernate and allow the application to terminate
    public  void close() {
        sessionFactory.close();
    }

    public  Session beginTransaction() {
        Session session = getSession();
        session.beginTransaction();
        return session;
    }

    public void commitTransaction() {
        getSession().getTransaction().commit();
    }

    public  void rollbackTransaction() {
        getSession().getTransaction().rollback();
    }
}