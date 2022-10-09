package com.daehan.FriendCommunityManager.controller;

import com.daehan.FriendCommunityManager.entity.Recruitment;
import com.daehan.FriendCommunityManager.model.WritingListItem;
import com.daehan.FriendCommunityManager.model.WritingRequest;
import com.daehan.FriendCommunityManager.service.RecruitmentService;
import com.daehan.FriendCommunityManager.service.WritingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/writing")
public class WritingController {
    private final RecruitmentService recruitmentService;
    private final WritingService writingService;

    // localhost:8080/writing/new/5
    @PostMapping("/new/{recruitmentId}")
    public String setDocument(@PathVariable long recruitmentId, @RequestBody WritingRequest writingRequest) {
        Recruitment recruitment = recruitmentService.getData(recruitmentId);
        writingService.setDocument(recruitment, writingRequest);

        return "등록에 성공하였습니다.";
    }

    @GetMapping("/my/{recruitmentId}")
    public List<WritingListItem> getMyDocuments(@PathVariable long recruitmentId) {
        return writingService.getDocuments(recruitmentId);
    }
}
