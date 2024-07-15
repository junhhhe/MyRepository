package com.example.one_practice.repository;

import com.example.one_practice.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long>{
    Boolean existsByUsername(String username);
    Member findByUsername(String username);
    Optional<Member> findByEmail(String email);
    boolean existsByEmail(String email);
}
