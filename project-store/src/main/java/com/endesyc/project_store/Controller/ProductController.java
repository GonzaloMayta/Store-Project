package com.endesyc.project_store.Controller;


import com.endesyc.project_store.Dto.ProductDto;

import com.endesyc.project_store.Entity.Product;

import com.endesyc.project_store.Service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
@AllArgsConstructor
public class ProductController {

    private ProductService productService;

    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable("id") Integer id){
        Product  productFound= productService.getById(id);
        return ResponseEntity.ok().body( productFound);
    }
    @PostMapping
    public ResponseEntity < Product> create(@RequestBody ProductDto dto){
        Product  productSaved= productService.create(dto);
        return ResponseEntity.status(HttpStatus.OK).body( productSaved);
    }


    @GetMapping("/product_pageable")
    public ResponseEntity<Page< Product>> getProducts(@RequestParam int page, @RequestParam int size){
        Pageable pageable= PageRequest.of(page, size);
        Page< Product>  productPage=productService.getProduct(pageable);

        return ResponseEntity.status(HttpStatus.OK).body(productPage);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity < Product> updateCategory(@PathVariable("id") Integer id,@RequestBody  ProductDto dto){
        Product  productFound=productService.getById(id);
        Product  productUpdated=productService.updateProduct(productFound.getId(),dto);
        return ResponseEntity.status(HttpStatus.OK).body(productUpdated);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable("id") Integer id){
        productService.deleteProduct(id);
        return ResponseEntity.ok().body("product is deleted successfully");
    }
    @GetMapping("/findproduct/{name}")
    public ResponseEntity<Product> getById(@PathVariable("name") String name){
        Product  productFound= productService.getByName(name);
        return ResponseEntity.ok().body( productFound);
    }
}
