package com.endesyc.project_store.Service;

import com.endesyc.project_store.Dto.CategoryDto;
import com.endesyc.project_store.Entity.Category;
import com.endesyc.project_store.Mapper.CategoryMapper;
import com.endesyc.project_store.Repository.CategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;

import java.util.List;

@AllArgsConstructor
@Setter
@Getter
@Service
public class CategoryServiceImpl implements CategoryService{
    private CategoryRepository categoryRepository;

    private CategoryMapper categoryMapper;
    @Override
    public Category getById(Integer id) {
        return categoryRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Category not found"));
    }


    @Override
    public Category create(CategoryDto dto) {
        Category category=categoryMapper.fromDto(dto);
        return categoryRepository.save(category);
    }

    @Override
    public Page<Category> getCategories(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }

    @Override
    public Category updateCategory(Integer id,CategoryDto dto) {
        Category category= new Category();
        if (this.getById(id) !=null){
             category=categoryMapper.updateDto(id,dto);
        }
        return categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(Integer id) {

    Category categoryFound=categoryRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Not found category"));
    categoryRepository.deleteById(id);

    }

    @Override
    public List<Category> listAllCategory() {
        List<Category> listCategory=categoryRepository.findAll();
        return listCategory;
    }


}
