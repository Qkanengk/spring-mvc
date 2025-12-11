package com.codegym.quan_ly_blog_api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BlogCreationRequestDTO {
    private Integer id;
    private String title;
    private String content;
    private Integer categoryId;
}
