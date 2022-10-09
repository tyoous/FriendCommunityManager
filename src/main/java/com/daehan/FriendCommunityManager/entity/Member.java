package com.daehan.FriendCommunityManager.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 관리자 여부
    @Column(nullable = false)
    private Boolean isAdmin;

    // 회원 아이디
    @Column(nullable = false, length = 20)
    private String username;

    // 회원 비밀번호
    @Column(nullable = false, length = 20)
    private String password;

    // 이름
    @Column(nullable = false, length = 15)
    public String name;
}
