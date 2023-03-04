package com.sebure.springcommonauth.entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name="resource_api")
@Entity
public class ResourceApi {
    @Id
    @Column(name ="id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "resourceApi")
    private List<AdminRoleResourceApiLink> adminRoleResourceApiLinkList = new ArrayList<>();

    @Column(name = "resource_category")
    private String resourceCategory; // TODO: enum

    @Column(name = "resource_type")
    private String resourceType;     // TODO: enum

    @Column(name = "resource_name")
    private String resourceName;

    @Column(name = "http_method")
    private String httpMethod;

    @Column(name = "http_url")
    private String httpUrl;

    @Column(name = "description")
    private String description;
//    private Long version; // TODO : version은 공통 부모엔티티에 정의하자.

}
