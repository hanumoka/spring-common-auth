package com.sebure.springcommonauth.entity;


import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name="ADMIN_USER")
@Entity
public class AdminUser {
    @Id
    @Column(name ="ADMIN_USER_ID")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long adminUserId;

    private String username;
    private String email;
    private String password;
    private Boolean active;
    private Boolean blocked;
    private String lastLoginIp;
    private LocalDateTime lastLoginTime;
}
