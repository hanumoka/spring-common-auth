package com.sebure.springcommonauth.entity;

import lombok.*;

import javax.persistence.*;

@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@DiscriminatorValue("member_user")
@PrimaryKeyJoinColumn(name="user_id")
@Table(name="member_user")
@Entity
public class MemberUser extends User {

    @Column(name = "nickname")
    private String nickname;

}
