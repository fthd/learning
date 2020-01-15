package com.learning.tkzc.convert;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class User {

    private Integer id;
    private String username;
    private String password;

    public User(Integer id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
}
