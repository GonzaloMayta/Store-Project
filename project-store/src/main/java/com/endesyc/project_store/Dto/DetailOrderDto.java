package com.endesyc.project_store.Dto;

import com.endesyc.project_store.Entity.Order;
import com.endesyc.project_store.Entity.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class DetailOrderDto {

    private Integer id;
    private Integer quantity;
    private Order order_id;
    private Product product_id;

}
