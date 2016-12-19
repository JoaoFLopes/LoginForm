package org.academiadecodigo.mavenlogin.persistence.hibernate;

import org.academiadecodigo.mavenlogin.persistence.TransactionManager;

/**
 * Created by codecadet on 06/12/16.
 */
public class HibernateTransactionManager implements TransactionManager {

    private HibernateSessionManager hibernateSessionManager;

    public HibernateTransactionManager(HibernateSessionManager hibernateSessionManager) {
        this.hibernateSessionManager = hibernateSessionManager;
    }

    @Override
    public void begin() {
        hibernateSessionManager.beginTransaction();
    }

    @Override
    public void commit() {
        hibernateSessionManager.commitTransaction();
    }

    @Override
    public void rollback() {
        hibernateSessionManager.rollbackTransaction();
    }

    public HibernateSessionManager getHibernateSessionManager() {
        return hibernateSessionManager;
    }

    public void setHibernateSessionManager(HibernateSessionManager hibernateSessionManager) {
        this.hibernateSessionManager = hibernateSessionManager;
    }
}
