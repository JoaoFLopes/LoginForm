package org.academiadecodigo.mavenlogin.model;

/**
 * Created by codecadet on 01/12/16.
 */
public class Role {

    private int id_role;
    private String type_role;

    public Role() {
    }

    public Role(int id_role, String type_role) {
        this.id_role = id_role;
        this.type_role = type_role;
    }

    public int getId_role() {
        return id_role;
    }

    public void setId_role(int id_role) {
        this.id_role = id_role;
    }

    public String getType_role() {
        return type_role;
    }

    public void setType_role(String type_role) {
        this.type_role = type_role;
    }
}
