package com.korai.servletstudy02.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor //필수
@AllArgsConstructor
public class User {
    private int id;
    private String username;
    private String password;
    private String name;

    // copy 생성자
    public User(User other) {
        this.id = other.id;
        this.username = other.username;
        this.password = other.password;
        this.name = other.name;
    }
}
