package com.daehan.FriendCommunityManager.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class RecruitmentRequest {
    private LocalDate dateStart;
    private LocalDate dateEnd;
}
