package com.sebure.springcommonauth.entity;


import com.sebure.springcommonauth.entity.base.BaseTimeEntity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Table(name="admin_user")
@Entity
public class AdminUser extends BaseTimeEntity {
    @Id
    @Column(name ="id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "adminUser")
    private List<AdminUserRoleLink> adminUserRoleLinkList = new ArrayList<>();

    @Column(name ="username")
    private String username;

    @Column(name ="email")
    private String email;

    @Column(name ="password")
    private String password;

    @Column(name ="active")
    private Boolean active;

    @Column(name ="blocked")
    private Boolean blocked;

    @Column(name ="last_login_ip")
    private String lastLoginIp;

    @Column(name ="last_login_datetime")
    private LocalDateTime lastLoginDateTime;
}
