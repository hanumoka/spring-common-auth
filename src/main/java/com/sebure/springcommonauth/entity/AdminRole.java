package com.sebure.springcommonauth.entity;


import com.sebure.springcommonauth.entity.base.BaseTimeEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name="admin_role")
@Entity
public class AdminRole extends BaseTimeEntity {

    @Id
    @Column(name ="id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "adminRole")
    private List<AdminUserRoleLink> adminUserRoleLinkList = new ArrayList<>();

    @OneToMany(mappedBy = "adminRole")
    private List<AdminRoleResourceApiLink> adminRoleResourceApiLinkList = new ArrayList<>();

    @Column(name ="role_name")
    private String roleName;

    @Column(name ="role_type")
    private String roleType;

    @Column(name ="description")
    private String description;
}
