package com.sebure.springcommonauth.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@PrimaryKeyJoinColumn(name="user_id")
@Table(name="member_user")
@Entity
public class MemberUser extends User {

    @Column(name = "nickname")
    private String nickname;

}
