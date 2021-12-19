package com.zhangchao.user.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author zhangchao
 * @date 2021/12/17
 */
@Entity
public class User {
    @Id
    private Integer id;

    private String password;

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
