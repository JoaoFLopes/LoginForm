package org.academiadecodigo.mavenlogin.model;

/**
 * Created by codecadet on 15/11/16.
 */
public class User {

    private String password;
    private String email;
    private int id;
    private String username;
    private Role role;




    public User() {
        role = new Role(1, "admin");
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
