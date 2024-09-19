package com.endesyc.project_store.Service;

import com.endesyc.project_store.Dto.CategoryDto;
import com.endesyc.project_store.Entity.Category;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CategoryService {

    Category getById(Integer id);
    Category create(CategoryDto dto);
    Page<Category> getCategories(Pageable pageable);
    Category updateCategory(Integer id,CategoryDto dto);
    void deleteCategory(Integer id);
    List<Category> listAllCategory();



}
