package com.example.one_practice.dto.board;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.format.DateTimeFormatter;

@NoArgsConstructor
@Builder
@Data
public class PageResponseDto {
    private Long articleId;
    private String articleTitle;
    private String memberNickname;
    private String createdAt;

    public static PageResponseDto of(Article article) {
        return PageResponseDto.builder()
                .articleId(article.getId())
                .articleTitle(article.getTitle())
                .memberNickname(article.getMember().getNickname())
                .createdAt(article.getCreatedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                .build();
    }
}
