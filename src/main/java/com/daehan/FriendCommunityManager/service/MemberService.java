package com.daehan.FriendCommunityManager.service;

import com.daehan.FriendCommunityManager.entity.Member;
import com.daehan.FriendCommunityManager.model.MemberJoinRequest;
import com.daehan.FriendCommunityManager.model.MemberLoginRequest;
import com.daehan.FriendCommunityManager.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public Member getData(long memberId) {
        return memberRepository.findById(memberId).orElseThrow();
    }

    /*
    기능 : 회원가입
    1. 아이디, 비밀번호, 이름을 입력한다.
    2. 1번에서 아이디가 영문이 아니라면 "영문으로 입력해주세요." 라고 에러를 뱉는다.
    3. 1번에서 비밀번호가 영문과 숫자가 아니고 7글자가 넘지 않는다면 "영문과 숫자를 입력하여 7글자 이상을 입력하세요."
    4. 1번에서 다른 회원자와 아이디가 겹치는게 있다면 "이 아이디는 사용할 수 없습니다." 라고 오류를 뱉는다.
    5. 이와 같은 오류가 없는지 확인 한 후 아이디 비밀번호 이름의 데이터를 데이터 베이스에 저장한다.
     */
    public void setMember(MemberJoinRequest joinRequest) {
        if (joinRequest.getPassword().length() < 7) throw new RuntimeException();
        if (!isDuplicateUsername(joinRequest.getUsername())) throw new RuntimeException();

        Member member = new Member();
        member.setIsAdmin(false);
        member.setUsername(joinRequest.getUsername());
        member.setPassword(joinRequest.getPassword());
        member.setName(joinRequest.getName());
        memberRepository.save(member);
    }

    /**
     * 회원 아이디 중복 검사
     * @param username 아이디
     * @return 중복된 아이디가 있으면 false, 중복된 아이디가 없으면 true
     */
    private boolean isDuplicateUsername(String username) {
        long duplicateCount = memberRepository.countByUsername(username);

        if (duplicateCount >= 1) return false;
        else return true;
    }


    /*
    기능 : 로그인하기
    1. 회원이 아이디와 비밀번호를 입력한다.
    2. 아이디가 일치하는 데이터를 데이터베이스에서 가져온다.
    3. 2번에서 데이터가 조회되지 않는다면 "존재하지 않는 아이디 입니다." 라고 에러를 뱉는다.
    4. 2번에서 데이터가 조회되었다면 데이터베이스에 저장된 비밀번호와 회원이 입력한 비밀번호가 같은지 확인한다.
    5. 이와 같은 조건이 맞아 떨어진다면 로그인이 된다.
     */
    public long doLogin(MemberLoginRequest loginRequest, boolean isAdmin) {
        Member member = memberRepository.findByUsername(loginRequest.getUsername()).orElseThrow();

        if (!member.getPassword().equals(loginRequest.getPassword())) throw new RuntimeException();

        return member.getId();
    }
}
