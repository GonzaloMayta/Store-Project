package com.endesyc.project_store.Mapper;

import com.endesyc.project_store.Dto.CategoryDto;
import com.endesyc.project_store.Entity.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {
    public Category fromDto(CategoryDto dto){
        Category category= new Category();
        category.setName(dto.getName());
        category.setDescription(dto.getDescription());
        category.setCreated_at(dto.getCreated_at());
        category.setUpdated_at(dto.getUpdated_at());
        category.setCreated_by(dto.getCreated_by());
        category.setUpdated_by(dto.getUpdated_by());

        return category;
    }
    public Category updateDto(Integer id,CategoryDto dto){
        Category category= new Category();
        category.setId(id);
        category.setName(dto.getName());
        category.setDescription(dto.getDescription());
        category.setCreated_at(dto.getCreated_at());
        category.setUpdated_at(dto.getUpdated_at());
        category.setCreated_by(dto.getCreated_by());
        category.setUpdated_by(dto.getUpdated_by());

        return category;
    }


}
