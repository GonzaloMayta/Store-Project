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

import java.util.List;

@RestController
@RequestMapping("/category")
@AllArgsConstructor
public class CategoryController {
    private CategoryService categoryService;

    @GetMapping("/{id}")
    public ResponseEntity<Category> getById(@PathVariable("id") Integer id){
        return ResponseEntity.ok().body(categoryService.getById(id));
    }
    @PostMapping
    public ResponseEntity <Category> create(@RequestBody CategoryDto dto){
            return ResponseEntity.status(HttpStatus.OK).body(categoryService.create(dto));
    }

    @GetMapping("/categories_pageable")
    public ResponseEntity<Page<Category>> getProducts(@RequestParam int page, @RequestParam int size){
        Pageable pageable= PageRequest.of(page, size);
        Page<Category> categoryPage=categoryService.getCategories(pageable);

        return ResponseEntity.status(HttpStatus.OK).body(categoryPage);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity <Category> updateCategory(@PathVariable("id") Integer id,@RequestBody CategoryDto dto){
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.updateCategory(id,dto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable("id") Integer id){
        categoryService.deleteCategory(id);
    return ResponseEntity.ok().body("Category is deleted successfully");
    }

    /* List all Categories*/
    @GetMapping("/listcategory")
    public ResponseEntity<List<Category>> listAllCategory(){
        return ResponseEntity.ok().body(categoryService.listAllCategory());
    }


}
