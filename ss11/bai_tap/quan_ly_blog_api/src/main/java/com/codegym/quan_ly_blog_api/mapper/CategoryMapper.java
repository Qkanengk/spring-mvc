package com.codegym.quan_ly_blog_api.mapper;

import com.codegym.quan_ly_blog_api.dto.CategoryResponseDTO;
import com.codegym.quan_ly_blog_api.entity.Category;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryResponseDTO toDTO(Category category);

    List<CategoryResponseDTO> toDTOs(List<Category> categories);
}
