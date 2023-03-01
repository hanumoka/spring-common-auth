package com.sebure.springcommonauth.entity;


import com.sebure.springcommonauth.entity.base.BaseTimeEntity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Table(name="ADMIN_USER")
@Entity
public class AdminUser extends BaseTimeEntity {
    @Id
    @Column(name ="ADMIN_USER_ID")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long adminUserId;

    @OneToMany(mappedBy = "adminUser")
    private List<AdminUserRoleLink> adminUserRoleLinkList = new ArrayList<>();

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

    @Column(name ="LAST_LOGIN_DATETIME")
    private LocalDateTime lastLoginDateTime;
}
