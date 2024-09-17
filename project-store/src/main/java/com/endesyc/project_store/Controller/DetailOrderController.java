package com.endesyc.project_store.Controller;

import com.endesyc.project_store.Dto.DetailOrderDto;
import com.endesyc.project_store.Entity.DetailOrder;
import com.endesyc.project_store.Service.DetailOrderService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/details")
public class DetailOrderController {
    private DetailOrderService detailOrderService;

    @GetMapping("/{id}")
    public ResponseEntity<DetailOrder> getById(@PathVariable("id") Integer id){
        DetailOrder detailFound=detailOrderService.getById(id);
        return ResponseEntity.ok().body(detailFound);
    }
    @PostMapping
    public ResponseEntity <DetailOrder> create(@RequestBody DetailOrderDto dto){
        DetailOrder detailSaved=detailOrderService.create(dto);
        return ResponseEntity.status(HttpStatus.OK).body(detailSaved);
    }


    @GetMapping("/details_pageable")
    public ResponseEntity<Page<DetailOrder>> getDetails(@RequestParam int page, @RequestParam int size){
        Pageable pageable= PageRequest.of(page, size);
        Page<DetailOrder> detailPage=detailOrderService.getDetail(pageable);

        return ResponseEntity.status(HttpStatus.OK).body(detailPage);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity <DetailOrder> updateDetail(@PathVariable("id") Integer id,@RequestBody DetailOrderDto dto){
        DetailOrder detailFound=detailOrderService.getById(id);
        DetailOrder detailUpdated=detailOrderService.updateDetail(detailFound.getId(),dto);
        return ResponseEntity.status(HttpStatus.OK).body(detailUpdated);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteDetail(@PathVariable("id") Integer id){
        detailOrderService.deleteDetail(id);
        return ResponseEntity.ok().body("Detail Order is deleted successfully");
    }



}
