package com.endesyc.project_store.Repository;

import com.endesyc.project_store.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {


    /*EndPoint para buscar una orden mediante nombre . . . .*/
    List<Order> findByName(String name);


}
