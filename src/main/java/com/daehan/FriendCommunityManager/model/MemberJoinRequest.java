package com.daehan.FriendCommunityManager.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberJoinRequest {
    // 프론트에서 입력받은 값 - 아이디
    private String username;
    // 프론트에서 입력받은 값 - 비밀번호
    private String password;
    // 프론트에서 입력받은 값 - 이름
    private String name;
}
