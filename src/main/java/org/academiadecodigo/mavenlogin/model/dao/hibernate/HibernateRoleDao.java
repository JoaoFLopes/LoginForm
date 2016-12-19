package org.academiadecodigo.mavenlogin.model.dao.hibernate;

import org.academiadecodigo.mavenlogin.model.Role;
import org.academiadecodigo.mavenlogin.model.dao.RoleDao;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 * Created by codecadet on 01/12/16.
 */
public class HibernateRoleDao extends HibernateDao<Role> implements RoleDao{


    public HibernateRoleDao() {
        super(Role.class);
    }

    @Override
    public Role findByRoleName(String name) {
        System.out.println("finding by name: " + name);
        Session session = getHibernateSessionManager().getSession();
        Query query = session.createQuery("FROM Role WHERE type_Role = :type_Role");
        query.setString("type_Role", name);

        Role role = (Role) query.uniqueResult();

        System.out.println("found " + role);

        return role;
    }
}
