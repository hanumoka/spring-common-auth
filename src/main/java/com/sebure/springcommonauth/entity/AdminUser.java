package com.sebure.springcommonauth.entity;


import com.sebure.springcommonauth.entity.auditing.BaseTimeEntity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name="ADMIN_USER")
@Entity
public class AdminUser extends BaseTimeEntity {
    @Id
    @Column(name ="ADMIN_USER_ID")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long adminUserId;

    @Column(name ="USERNAME")
    private String username;

    @Column(name ="EMAIL")
    private String email;

    @Column(name ="PASSWORD")
    private String password;

    @Column(name ="ACTIVE")
    private Boolean active;

    @Column(name ="BLOCKED")
    private Boolean blocked;

    @Column(name ="LAST_LOGIN_IP")
    private String lastLoginIp;

    @Column(name ="Last Login Time")
    private LocalDateTime lastLoginTime;
}
