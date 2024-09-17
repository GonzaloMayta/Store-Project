package com.endesyc.project_store.Service;

import com.endesyc.project_store.Dto.DetailOrderDto;
import com.endesyc.project_store.Entity.DetailOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface DetailOrderService {
    DetailOrder getById(Integer id);
    DetailOrder create(DetailOrderDto dto);
    Page<DetailOrder> getDetail(Pageable pageable);
    DetailOrder updateDetail(Integer id, DetailOrderDto dto);
    void deleteDetail(Integer id);

}
