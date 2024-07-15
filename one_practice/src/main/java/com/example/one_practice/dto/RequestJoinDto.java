package com.example.one_practice.dto;

import com.example.one_practice.entity.Member;
import com.example.one_practice.jwt.MemberRole;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RequestJoinDto {

    private String username;
    private String password;
    private String passwordCheck;
    private String name;

    public Member toEntity(){
        return Member.builder()
                .username(this.username)
                .password(this.password)
                .role(MemberRole.USER)
                .build();
    }
}

