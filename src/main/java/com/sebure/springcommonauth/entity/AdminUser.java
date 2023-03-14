package com.sebure.springcommonauth.entity;


import com.sebure.springcommonauth.entity.base.BaseTimeEntity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name="admin_user")
@Entity
public class AdminUser extends User {
//    @Id
//    @Column(name ="id")
//    @GeneratedValue(strategy= GenerationType.IDENTITY)
//    private Long id;

    @OneToMany(mappedBy = "adminUser")
    private List<AdminUserRoleLink> adminUserRoleLinkList = new ArrayList<>();

//    @Column(name ="username")
//    private String username;

    @Column(name ="email")
    private String email;

//    @Column(name ="password")
//    private String password;

    @Column(name ="active")
    private Boolean active;

    @Column(name ="blocked")
    private Boolean blocked;

    @Column(name ="last_login_ip")
    private String lastLoginIp;

    @Column(name ="last_login_datetime")
    private LocalDateTime lastLoginDateTime;

//    public static AdminUser create(String username, String email, String password,
//                         Boolean active, Boolean blocked) {
//        return AdminUser.builder()
//                .username(username)
//                .email(email)
//                .password(password)
//                .active(active)
//                .blocked(blocked)
//                .build();
//    }

//    public void update(String username, String email, Boolean active, Boolean blocked){
//        this.username = username;
//        this.email = email;
//        this.active = active;
//        this.blocked = blocked;
//    }

//    public void updatePassword(String password){
//        this.password = password;
//    }


}
