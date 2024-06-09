package com.example.one_practice.controller;

import com.example.one_practice.dto.MemberDto;
import com.example.one_practice.service.JoinService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ResponseBody
@AllArgsConstructor
public class MemberCreateContorller {

    private final JoinService joinService;

    @PostMapping("/join")
    public String joinProcess(MemberDto memberDto) {

        joinService.joinProcess(memberDto);

        return "ok";
    }

}