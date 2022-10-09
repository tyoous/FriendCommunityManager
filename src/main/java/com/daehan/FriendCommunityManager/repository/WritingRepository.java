package com.daehan.FriendCommunityManager.repository;

import com.daehan.FriendCommunityManager.entity.Writing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WritingRepository extends JpaRepository<Writing, Long> {
    List<Writing> findAllByRecruitment_IdOrderByIdDesc(long recruitmentId);
}
