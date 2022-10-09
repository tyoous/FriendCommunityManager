package com.daehan.FriendCommunityManager.controller;

import com.daehan.FriendCommunityManager.entity.Member;
import com.daehan.FriendCommunityManager.model.RecruitmentRequest;
import com.daehan.FriendCommunityManager.service.MemberService;
import com.daehan.FriendCommunityManager.service.RecruitmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/recruitment")
public class RecruitmentController {
    private final MemberService memberService;
    private final RecruitmentService recruitmentService;

    @PostMapping("/new/{memberId}")
    public String setRecruitment(@PathVariable long memberId, @RequestBody RecruitmentRequest recruitmentRequest) {
        Member member = memberService.getData(memberId);
        recruitmentService.setRecruitment(member, recruitmentRequest);

        return "등록에 성공하였습니다.";
    }
}
