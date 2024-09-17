package com.endesyc.project_store.Service;

import com.endesyc.project_store.Dto.CategoryDto;
import com.endesyc.project_store.Dto.OrderDto;
import com.endesyc.project_store.Entity.Category;
import com.endesyc.project_store.Entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface OrderService {

    Order getById(Integer id);
    Order create(OrderDto dto);
    Page<Order> getOrders(Pageable pageable);
    Order updateOrder(Integer id,OrderDto dto);
    void deleteOrder(Integer id);

    /*EndPoint para buscar una orden mediante nombre . . . .*/
    List<Order> findByName(String name);
}
