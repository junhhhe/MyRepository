package com.example.one_practice.service;

import com.example.one_practice.dto.MemberDto;
import com.example.one_practice.entity.Member;
import com.example.one_practice.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JoinService {

    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    //회원가입 로직
    public void joinProcess(MemberDto requestMemberDto){

        String username = requestMemberDto.getUsername();
        String password = requestMemberDto.getPassword();

        Boolean isExist = memberRepository.existsByUsername(username);

        if(isExist){

            return;
        }

        Member data = new Member();
        data.setUsername(username);
        data.setPassword(bCryptPasswordEncoder.encode(password));
        data.setRole("ROLE_ADMIN");

        memberRepository.save(data);
    }
}
