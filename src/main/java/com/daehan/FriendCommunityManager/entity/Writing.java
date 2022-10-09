package com.daehan.FriendCommunityManager.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Writing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    // 친구모집 번호 참조
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RecruitmentId")
    private Recruitment recruitment;

    // 작성 날짜
    @Column(nullable = false)
    private LocalDateTime writeDate;

    // 작성자
    @Column(nullable = false, length = 20)
    private String anonymousName;

    // 글 내용
    @Column(nullable = false, columnDefinition = "TEXT")
    private String contents;
}
