package org.academiadecodigo.mavenlogin.model.dao.hibernate;

import org.academiadecodigo.mavenlogin.model.dao.Dao;
import org.academiadecodigo.mavenlogin.persistence.TransactionException;
import org.academiadecodigo.mavenlogin.persistence.hibernate.HibernateSessionManager;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;

import java.util.List;

/**
 * Created by codecadet on 06/12/16.
 */
public abstract class HibernateDao<E> implements Dao<E> {

    private HibernateSessionManager hibernateSessionManager;
    private Class<E> type;

    public HibernateDao(Class<E> type) {
        this.type = type;
    }

    public Class<E> getType() {
        return type;
    }

    public void setType(Class<E> type) {
        this.type = type;
    }


    @Override
    public void save(E object) {
        Session s = hibernateSessionManager.getSession();
        s.save(object);

    }
    @Override
    public void delete(E object) {
        Session s = hibernateSessionManager.getSession();

        s.delete(object);
    }

    @Override
    public Long count() {
        return (Long) hibernateSessionManager.getSession().createCriteria(type).setProjection(Projections.rowCount()).uniqueResult();
    }

    @Override
    public List<E> findAll() {
        try {
            return hibernateSessionManager.getSession().createCriteria(type).list();
        } catch (TransactionException ex){
            throw new TransactionException(ex);
        }
    }

    public HibernateSessionManager getHibernateSessionManager() {
        return hibernateSessionManager;
    }

    public void setHibernateSessionManager(HibernateSessionManager hibernateSessionManager) {
        this.hibernateSessionManager = hibernateSessionManager;
    }
}
