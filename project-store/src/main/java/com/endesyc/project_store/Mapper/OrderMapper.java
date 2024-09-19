package com.endesyc.project_store.Mapper;

import com.endesyc.project_store.Dto.OrderDto;
import com.endesyc.project_store.Entity.Order;
import com.endesyc.project_store.Entity.Store;
import org.springframework.stereotype.Component;


@Component
public class OrderMapper {
    public Order fromDto(OrderDto dto){
        Order order=new Order();

        order.setName(dto.getName());
        order.setDate(dto.getDate());
        order.setShippingAddress(dto.getShippingAddress());
        order.setIsDelivery(dto.getIsDelivery());
        order.setCreatedAt(dto.getCreatedAt());
        order.setUpdatedAt(dto.getUpdatedAt());
        order.setCreatedBy(dto.getCreatedBy());
        order.setUpdatedBy(dto.getUpdatedBy());
        order.setStoreId(dto.getStoreId());
      return order;

    }

    public Order updateDto(Integer id, OrderDto dto){
        Order order=new Order();
        order.setId(id);
        order.setName(dto.getName());
        order.setDate(dto.getDate());
        order.setShippingAddress(dto.getShippingAddress());
        order.setIsDelivery(dto.getIsDelivery());
        order.setCreatedAt(dto.getCreatedAt());
        order.setUpdatedAt(dto.getUpdatedAt());
        order.setCreatedBy(dto.getCreatedBy());
        order.setUpdatedBy(dto.getUpdatedBy());
        order.setStoreId(dto.getStoreId());
        return order;
    }
}
