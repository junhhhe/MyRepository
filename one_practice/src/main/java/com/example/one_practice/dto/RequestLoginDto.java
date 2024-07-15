package com.example.one_practice.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RequestLoginDto {

    private String username;
    private String password;
}
