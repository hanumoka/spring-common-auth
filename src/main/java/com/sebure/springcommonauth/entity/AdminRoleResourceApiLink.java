package com.sebure.springcommonauth.entity;

import javax.persistence.*;

@Table(name="admin_role_resource_api_link")
@Entity
public class AdminRoleResourceApiLink {

    @Id
    @Column(name ="id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "admin_role_id")
    @ManyToOne
    private AdminRole adminRole;

    @JoinColumn(name = "resource_api_id")
    @ManyToOne
    private ResourceApi resourceApi;
}
