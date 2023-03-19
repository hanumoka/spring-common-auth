package com.sebure.springcommonauth.entity;

import com.sebure.springcommonauth.entity.base.BaseEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.time.LocalDateTime;


@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Table(name = "user")
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "user_type", discriminatorType = DiscriminatorType.STRING)
public abstract class User extends BaseEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "user_type", insertable = false, updatable = false)
    private String userType;

    @Column(name = "active", columnDefinition = "TINYINT")
    private Boolean active;

    @Column(name = "blocked", columnDefinition = "TINYINT")
    private Boolean blocked;

    @Column(name = "email")
    private String email;

    @Column(name = "last_login_ip")
    private String lastLoginIp;

    @Column(name = "last_login_datetime")
    private LocalDateTime lastLoginDateTime;

    public boolean checkMemberValidity(){
        return this.getActive() && !this.getBlocked();
    }

    public boolean checkPassword(String password, PasswordEncoder passwordEncoder) {
        return passwordEncoder.matches(password, this.getPassword());
    }

}
