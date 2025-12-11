package com.codegym.quan_ly_blog_api.mapper;

import com.codegym.quan_ly_blog_api.dto.BlogCreationRequestDTO;
import com.codegym.quan_ly_blog_api.dto.BlogResponseDTO;
import com.codegym.quan_ly_blog_api.entity.Blog;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BlogMapper {
    @Mapping(source = "category.name", target = "categoryName")
    @Mapping(source = "category.id", target = "categoryId")
    BlogResponseDTO toResponseDTO(Blog blog) ;

    List<BlogResponseDTO> toResponseList(List<Blog> blogList);

    @Mapping(target = "id", ignore = true) // Tạo mới thì không map ID
    @Mapping(source = "categoryId", target = "category.id") // Category sẽ set thủ công trong Service sau
    Blog toEntity(BlogCreationRequestDTO request);
}
