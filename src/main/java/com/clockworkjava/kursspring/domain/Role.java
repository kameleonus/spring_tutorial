package com.clockworkjava.kursspring.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String userName;
    private String userRole;
    public Role(){}

    public Role(String username, String userRole) {
        this.userName = username;
        this.userRole = userRole;
    }
}
