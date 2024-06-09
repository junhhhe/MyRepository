package com.example.one_practice.repository;

import com.example.one_practice.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Boolean existsByUsername(String username);
    Member findByUsername(String username);
}
