package com.sebure.springcommonauth.entity;

import com.sebure.springcommonauth.entity.base.BaseEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;


@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Table(name = "user")
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "dtype")
public abstract class User extends BaseEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "blocked")
    private Boolean blocked;

    @Column(name = "email")
    private String email;

    @Column(name = "last_login_ip")
    private String lastLoginIp;

    @Column(name = "last_login_datetime")
    private LocalDateTime lastLoginDateTime;

}
