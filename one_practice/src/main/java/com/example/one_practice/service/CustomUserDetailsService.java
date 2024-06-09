package com.example.one_practice.service;

import com.example.one_practice.dto.CustomUserDetails;
import com.example.one_practice.entity.Member;
import com.example.one_practice.repository.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final MemberRepository memberJpaRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Member memberData = memberJpaRepository.findByUsername(username);

        if(memberData != null){
            return new CustomUserDetails(memberData);
        }

        return null;
    }
}
