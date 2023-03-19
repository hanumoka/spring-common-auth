package com.sebure.springcommonauth.entity;


import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@PrimaryKeyJoinColumn(name="user_id")
@DiscriminatorValue("admin_user")
@Table(name="admin_user")
@Entity
public class AdminUser extends User {

    @OneToMany(mappedBy = "adminUser")
    private List<AdminUserRoleLink> adminUserRoleLinkList = new ArrayList<>();




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
