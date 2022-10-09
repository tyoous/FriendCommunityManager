package com.daehan.FriendCommunityManager.repository;

import com.daehan.FriendCommunityManager.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    long countByUsername(String username);
    Optional<Member> findByUsername(String username);
}
