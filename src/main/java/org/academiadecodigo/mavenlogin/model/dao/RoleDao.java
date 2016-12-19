package org.academiadecodigo.mavenlogin.model.dao;

import org.academiadecodigo.mavenlogin.model.Role;

import java.util.List;

/**
 * Created by codecadet on 01/12/16.
 */
public interface RoleDao extends Dao<Role> {


    Role findByRoleName(String name);


}
