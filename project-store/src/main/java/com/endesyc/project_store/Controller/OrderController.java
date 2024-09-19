package com.endesyc.project_store.Controller;

import com.endesyc.project_store.Dto.OrderDto;
import com.endesyc.project_store.Entity.Order;
import com.endesyc.project_store.Service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/order")
public class OrderController {

    private OrderService orderService;

    @GetMapping("/{id}")
    public ResponseEntity<Order> getById(@PathVariable("id") Integer id){
        return ResponseEntity.ok().body(orderService.getById(id));
    }

    @PostMapping
    public ResponseEntity <Order> create(@RequestBody OrderDto dto){
        return ResponseEntity.status(HttpStatus.OK).body(orderService.create(dto));
    }


    @GetMapping("/orders_pageable")
    public ResponseEntity<Page<Order>> getProducts(@RequestParam int page, @RequestParam int size){
        Pageable pageable= PageRequest.of(page, size);
        Page<Order> orderPage=orderService.getOrders(pageable);

        return ResponseEntity.status(HttpStatus.OK).body(orderPage);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity <Order> updateOrder(@PathVariable("id") Integer id,@RequestBody OrderDto dto){
        return ResponseEntity.status(HttpStatus.OK).body(orderService.updateOrder(id,dto));
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable("id") Integer id){
        orderService.deleteOrder(id);
        return ResponseEntity.ok().body("Order is deleted successfully");
    }

    /*EndPoint para buscar una orden mediante nombre . . . .*/
    @GetMapping("/findorder/{name}")
    public ResponseEntity<List<Order>> getById(@PathVariable("name") String name){
        List<Order>  orderFound= orderService.findByName(name);
        return ResponseEntity.ok().body(orderFound);
    }

}
