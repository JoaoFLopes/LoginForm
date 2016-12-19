package org.academiadecodigo.mavenlogin.model.dao;

import java.util.List;

/**
 * Created by codecadet on 06/12/16.
 */
public interface Dao <E>{

    void save(E object);
    void delete(E object);
    Long count();
    List<E> findAll();
}
