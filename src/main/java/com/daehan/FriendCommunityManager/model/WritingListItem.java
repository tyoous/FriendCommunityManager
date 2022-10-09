package com.daehan.FriendCommunityManager.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class WritingListItem {
    // 작성 날짜
    private LocalDateTime writeDate;

    // 작성자
    private String anonymousName;

    // 글 내용
    private String contents;
}
