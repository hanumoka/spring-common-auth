package com.sebure.springcommonauth.entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name="RESOURCE_API")
@Entity
public class ResourceApi {
    @Id
    @Column(name ="RESOURCE_API_ID")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long ResourceApiId;

    @OneToMany(mappedBy = "resourceApi")
    private List<AdminRoleResourceApiLink> adminRoleResourceApiLinkList = new ArrayList<>();

    @Column(name = "RESOURCE_CATEGORY")
    private String resourceCategory; // TODO: enum

    @Column(name = "RESOURCE_TYPE")
    private String resourceType;     // TODO: enum

    @Column(name = "RESOURCE_NAME")
    private String resourceName;

    @Column(name = "HTTP_METHOD")
    private String httpMethod;

    @Column(name = "HTTP_URL")
    private String httpUrl;

    @Column(name = "DESCRIPTION")
    private String description;
//    private Long version; // TODO : version은 공통 부모엔티티에 정의하자.

}
