package com.endesyc.project_store.Mapper;

import com.endesyc.project_store.Dto.DetailOrderDto;
import com.endesyc.project_store.Entity.DetailOrder;
import org.springframework.stereotype.Component;

@Component
public class DetailOrderMapper {

    public DetailOrder fromDto(DetailOrderDto dto){
        DetailOrder detailOrder = new DetailOrder();
        detailOrder.setQuantity(dto.getQuantity());
        detailOrder.setOrderId(dto.getOrderId());
        detailOrder.setProductId(dto.getProductId());

        return detailOrder;
    }

    public DetailOrder updateDto(Integer id, DetailOrderDto dto){
        DetailOrder detailOrder = new DetailOrder();
        detailOrder.setId(id);
        detailOrder.setQuantity(dto.getQuantity());
        detailOrder.setOrderId(dto.getOrderId());
        detailOrder.setProductId(dto.getProductId());

        return detailOrder;
    }


}
