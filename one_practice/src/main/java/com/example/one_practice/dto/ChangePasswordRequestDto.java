package com.example.one_practice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
//비밀번호를 수정할 때 쓰이는 dto
public class ChangePasswordRequestDto {
    private String email;
    private String exPassword;
    private String newPassword;
}
