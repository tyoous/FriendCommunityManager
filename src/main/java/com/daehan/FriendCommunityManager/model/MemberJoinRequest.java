package com.daehan.FriendCommunityManager.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberJoinRequest {
    private String username;

    private String password;

    private String name;
}
