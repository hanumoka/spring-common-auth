package com.sebure.springcommonauth.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public abstract class User {

    @Id
    @Column(name ="id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name ="active")
    private Boolean active;

    @Column(name ="blocked")
    private Boolean blocked;
}
