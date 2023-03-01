package com.sebure.springcommonauth.entity;

import javax.persistence.*;

@Table(name="ADMIN_ROLE_RESOURCE_API_LINK")
@Entity
public class AdminRoleResourceApiLink {

    @Id
    @Column(name ="ADMIN_ROLE_RESOURCE_API_LINK_ID")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long adminRoleResourceApiLinkId;

    @JoinColumn(name = "ADMIN_ROLE_ID")
    @ManyToOne
    private AdminRole adminRole;

    @JoinColumn(name = "RESOURCE_API_ID")
    @ManyToOne
    private ResourceApi resourceApi;
}
