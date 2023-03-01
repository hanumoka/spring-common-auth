package com.sebure.springcommonauth.entity;


import javax.persistence.*;
import java.util.ArrayList;

@Table(name="ADMIN_USER_ROLE_LINK")
@Entity
public class AdminUserRoleLink {

    @Id
    @Column(name ="ADMIN_USER_ROLE_LINK_ID")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long adminUserRoleLinkId;

    @JoinColumn(name ="ADMIN_USER_ID")
    @ManyToOne
    private AdminUser adminUser;

    @JoinColumn(name = "ADMIN_ROLE_ID")
    @ManyToOne
    private AdminRole adminRole;
}
