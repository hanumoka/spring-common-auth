package com.sebure.springcommonauth.entity;


import com.sebure.springcommonauth.entity.base.BaseTimeEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name="ADMIN_ROLE")
@Entity
public class AdminRole extends BaseTimeEntity {

    @Id
    @Column(name ="ADMIN_ROLE_ID")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long adminRoleId;

    @OneToMany(mappedBy = "adminRole")
    private List<AdminUserRoleLink> adminUserRoleLinkList = new ArrayList<>();

    @OneToMany(mappedBy = "adminRole")
    private List<AdminRoleResourceApiLink> adminRoleResourceApiLinkList = new ArrayList<>();

    @Column(name ="ROLE_NAME")
    private String roleName;

    @Column(name ="ROLE_TYPE")
    private String roleType;

    @Column(name ="DESCRIPTION")
    private String description;
}
