package org.syspro.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "educators")
public class EducatorEntity {
    @Id
    private long id;
    private String login, password, fullName;

    public EducatorEntity() {
    }

    public EducatorEntity(String login, String password, String fullName) {
        this.login = login;
        this.password = password;
        this.fullName = fullName;
    }

    public long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}