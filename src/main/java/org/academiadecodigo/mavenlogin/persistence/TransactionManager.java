package org.academiadecodigo.mavenlogin.persistence;

/**
 * Created by codecadet on 06/12/16.
 */
public interface TransactionManager {

    void begin();

    void commit();

    void rollback();
}
