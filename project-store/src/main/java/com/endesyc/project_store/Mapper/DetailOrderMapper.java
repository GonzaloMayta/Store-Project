package com.endesyc.project_store.Mapper;

import com.endesyc.project_store.Dto.DetailOrderDto;
import com.endesyc.project_store.Entity.DetailOrder;
import org.springframework.stereotype.Component;

@Component
public class DetailOrderMapper {

    public DetailOrder fromDto(DetailOrderDto dto){
        DetailOrder detailOrder = new DetailOrder();
        detailOrder.setQuantity(dto.getQuantity());
        detailOrder.setOrder_id(dto.getOrder_id());
        detailOrder.setProduct_id(dto.getProduct_id());

        return detailOrder;
    }

    public DetailOrder updateDto(Integer id, DetailOrderDto dto){
        DetailOrder detailOrder = new DetailOrder();
        detailOrder.setId(id);
        detailOrder.setQuantity(dto.getQuantity());
        detailOrder.setOrder_id(dto.getOrder_id());
        detailOrder.setProduct_id(dto.getProduct_id());

        return detailOrder;
    }


}
