package com.daehan.FriendCommunityManager.service;

import com.daehan.FriendCommunityManager.entity.Member;
import com.daehan.FriendCommunityManager.entity.Recruitment;
import com.daehan.FriendCommunityManager.model.RecruitmentRequest;
import com.daehan.FriendCommunityManager.repository.RecruitmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RecruitmentService {
    private final RecruitmentRepository recruitmentRepository;

    public Recruitment getData(long id) {
        return recruitmentRepository.findById(id).orElseThrow();
    }

    /*
    기능 : 친구모집 기간
    1. 회원이 모집 시작일과 모집 종료일을 설정한다.
    2. 모집 데이터를 저장한다.
     */
    public void setRecruitment(Member member, RecruitmentRequest recruitmentRequest) {
        Recruitment recruitment = new Recruitment();
        recruitment.setMember(member);
        recruitment.setStartDate(recruitmentRequest.getDateStart());
        recruitment.setEndDate(recruitmentRequest.getDateEnd());

        recruitmentRepository.save(recruitment);
    }

}
