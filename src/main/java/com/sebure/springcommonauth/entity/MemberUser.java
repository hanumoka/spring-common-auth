package com.sebure.springcommonauth.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@PrimaryKeyJoinColumn(name="user_id")
@Entity
public class MemberUser extends User {

    @Column(name="email")
    private String email;

}
