package com.myblog.myblog.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "password")
public class PassWord {
    public PassWord(PassWord passWord) {
        this.id=passWord.getId();
        this.name = passWord.getName();
        this.password = passWord.getPassword();
    }

    public PassWord() {
    }

    @GeneratedValue
    @Id
    private Integer id;
    private String name;
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
