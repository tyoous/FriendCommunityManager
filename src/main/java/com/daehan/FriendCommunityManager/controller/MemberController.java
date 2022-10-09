package com.daehan.FriendCommunityManager.controller;

import com.daehan.FriendCommunityManager.model.MemberJoinRequest;
import com.daehan.FriendCommunityManager.model.MemberLoginRequest;
import com.daehan.FriendCommunityManager.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;

    // localhost:8080/member/new
    @PostMapping("/new")
    public String setMember(@RequestBody MemberJoinRequest memberJoinRequest) {
        memberService.setMember(memberJoinRequest);
        return "등록되었습니다.";
    }

    // 일반회원용 로그인
    @PostMapping("/login/normal")
    public long doLoginNormal(@RequestBody MemberLoginRequest memberLoginRequest) {
        return memberService.doLogin(memberLoginRequest, false);
    }

    // 관리자용 로그인
    @PostMapping("/login/admin")
    public long doLoginAdmin(@RequestBody MemberLoginRequest memberLoginRequest) {
        return memberService.doLogin(memberLoginRequest, true);
    }
}
