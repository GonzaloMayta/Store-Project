package com.endesyc.project_store.Mapper;

import com.endesyc.project_store.Dto.OrderDto;
import com.endesyc.project_store.Entity.Order;
import com.endesyc.project_store.Entity.Store;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Date;

@Component
public class OrderMapper {
    public Order fromDto(OrderDto dto){
        Order order=new Order();

        order.setName(dto.getName());
        order.setDate(dto.getDate());
        order.setShipping_address(dto.getShipping_address());
        order.setIs_delivery(dto.getIs_delivery());
        order.setCreated_at(dto.getCreated_at());
        order.setUpdated_at(dto.getUpdated_at());
        order.setCreated_by(dto.getCreated_by());
        order.setUpdated_by(dto.getUpdated_by());
        order.setStore_id(dto.getStore_id());
      return order;

    }

    public Order updateDto(Integer id, OrderDto dto){
        Order order=new Order();
        order.setId(id);
        order.setName(dto.getName());
        order.setDate(dto.getDate());
        order.setShipping_address(dto.getShipping_address());
        order.setIs_delivery(dto.getIs_delivery());
        order.setCreated_at(dto.getCreated_at());
        order.setUpdated_at(dto.getUpdated_at());
        order.setCreated_by(dto.getCreated_by());
        order.setUpdated_by(dto.getUpdated_by());
        order.setStore_id(dto.getStore_id());

        return order;
    }
}
