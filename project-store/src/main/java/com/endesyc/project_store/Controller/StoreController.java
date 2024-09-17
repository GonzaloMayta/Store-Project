package com.endesyc.project_store.Controller;


import com.endesyc.project_store.Dto.StoreDto;

import com.endesyc.project_store.Entity.Store;

import com.endesyc.project_store.Service.StoreService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/store")
@AllArgsConstructor
public class StoreController {
    private StoreService storeService;

    @GetMapping("/{id}")
    public ResponseEntity<Store> getById(@PathVariable("id") Integer id){
        Store  storeFound= storeService.getById(id);
        return ResponseEntity.ok().body( storeFound);
    }
    @PostMapping
    public ResponseEntity < Store> create(@RequestBody StoreDto dto){
        Store  storeSaved= storeService.create(dto);
        return ResponseEntity.status(HttpStatus.OK).body( storeSaved);
    }


    @GetMapping("/store_pageable")
    public ResponseEntity<Page< Store>> getStores(@RequestParam int page, @RequestParam int size){
        Pageable pageable= PageRequest.of(page, size);
        Page< Store>  storePage=storeService.getStore(pageable);

        return ResponseEntity.status(HttpStatus.OK).body(storePage);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity < Store> updateStore(@PathVariable("id") Integer id,@RequestBody  StoreDto dto){
        Store  storeFound=storeService.getById(id);
        Store  storeUpdated=storeService.updateStore(storeFound.getId(),dto);
        return ResponseEntity.status(HttpStatus.OK).body(storeUpdated);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable("id") Integer id){
        storeService.deleteStore(id);
        return ResponseEntity.ok().body("Store is deleted successfully");
    }
}
