package com.endesyc.project_store.Service;

import com.endesyc.project_store.Dto.OrderDto;
import com.endesyc.project_store.Entity.Order;
import com.endesyc.project_store.Mapper.OrderMapper;
import com.endesyc.project_store.Repository.OrderRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Setter
@Getter
@Service
public class OrderServiceImpl implements OrderService{
    private OrderRepository orderRepository;

    private OrderMapper orderMapper;
    @Override
    public Order getById(Integer id) {
        return orderRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Order not found"));
    }


    @Override
    public Order create(OrderDto dto) {
        Order order=orderMapper.fromDto(dto);
        return orderRepository.save(order);
    }

    @Override
    public Page<Order> getOrders(Pageable pageable) {
        return orderRepository.findAll(pageable);
    }

    @Override
    public Order updateOrder(Integer id,OrderDto dto) {
        Order order=new Order();

        if(this.getById(id)!=null){
            order=orderMapper.updateDto(id,dto);
        }
        return orderRepository.save(order);
    }

    @Override
    public void deleteOrder(Integer id) {

        Order orderFound=orderRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Not found order"));
        orderRepository.deleteById(id);

    }
    /*EndPoint para buscar una orden mediante nombre . . . .*/
    public List<Order> findByName(String name) {
        return orderRepository.findByName(name);
    }
}
