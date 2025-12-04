package com.codegym.quan_ly_blog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogDto {
    private Integer id;
    private String title;
    private String content;
    private Integer categoryId;
    private String categoryName;
}
