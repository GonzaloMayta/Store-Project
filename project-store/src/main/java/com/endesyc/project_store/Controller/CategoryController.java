package com.endesyc.project_store.Controller;


import com.endesyc.project_store.Dto.CategoryDto;
import com.endesyc.project_store.Entity.Category;
import com.endesyc.project_store.Service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
@AllArgsConstructor
public class CategoryController {
    private CategoryService categoryService;

    @GetMapping("/{id}")
    public ResponseEntity<Category> getById(@PathVariable("id") Integer id){
        Category categoryFound=categoryService.getById(id);
        return ResponseEntity.ok().body(categoryFound);
    }
@PostMapping
public ResponseEntity <Category> create(@RequestBody CategoryDto dto){
        Category categorySaved=categoryService.create(dto);
        return ResponseEntity.status(HttpStatus.OK).body(categorySaved);
}


    @GetMapping("/categories_pageable")
    public ResponseEntity<Page<Category>> getProducts(@RequestParam int page, @RequestParam int size){
        Pageable pageable= PageRequest.of(page, size);
        Page<Category> categoryPage=categoryService.getCategories(pageable);

        return ResponseEntity.status(HttpStatus.OK).body(categoryPage);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity <Category> updateCategory(@PathVariable("id") Integer id,@RequestBody CategoryDto dto){
        Category categoryFound=categoryService.getById(id);
        Category categoryUpdated=categoryService.updateCategory(categoryFound.getId(),dto);
        return ResponseEntity.status(HttpStatus.OK).body(categoryUpdated);
    }
@DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable("id") Integer id){
        categoryService.deleteCategory(id);
        return ResponseEntity.ok().body("Category is deleted successfully");
    }



}
