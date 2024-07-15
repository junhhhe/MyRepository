package com.example.one_practice.dto.board;

import lombok.Data;

@Data
public class CreateArticleRequestDto {
    private String title;
    private String body;
}