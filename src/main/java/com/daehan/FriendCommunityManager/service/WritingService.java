package com.daehan.FriendCommunityManager.service;

import com.daehan.FriendCommunityManager.entity.Recruitment;
import com.daehan.FriendCommunityManager.entity.Writing;
import com.daehan.FriendCommunityManager.model.WritingListItem;
import com.daehan.FriendCommunityManager.model.WritingRequest;
import com.daehan.FriendCommunityManager.repository.WritingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WritingService {
    private final WritingRepository writingRepository;

    /*
    기능 : 비회원자 글 작성
    1. 회원가입자의 로그인이 되어있다면 로그인 된 주소를 복사하여 친구들에게 공유를 한다.
    2. 친구들은 회원가입자에게 링크를 공유 받았다면 링크를 클릭한다.
    3. 2번에서 링크를 클릭 한 후 친구들은 글을 작성 할 수 있다.
     */

    public void setDocument(Recruitment recruitment, WritingRequest writingRequest) {
        Writing writing = new Writing();
        writing.setRecruitment(recruitment);
        writing.setWriteDate(LocalDateTime.now());
        writing.setAnonymousName(writingRequest.getAnonymousName());
        writing.setContents(writingRequest.getContents());

        writingRepository.save(writing);
    }

    /*
    기능 : 내 친구들이 작성한 글들을 가져온다.
     */
    public List<WritingListItem> getDocuments(long recruitmentId) {
        List<Writing> writings = writingRepository.findAllByRecruitment_IdOrderByIdDesc(recruitmentId);
        List<WritingListItem> result = new LinkedList<>();

        for (Writing writing : writings) {
            WritingListItem addItem = new WritingListItem();
            addItem.setWriteDate(writing.getWriteDate());
            addItem.setAnonymousName(writing.getAnonymousName());
            addItem.setContents(writing.getContents());

            result.add(addItem);
        }

        return result;
    }
}
