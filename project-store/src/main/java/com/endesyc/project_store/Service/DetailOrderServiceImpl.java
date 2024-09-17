package com.endesyc.project_store.Service;

import com.endesyc.project_store.Dto.DetailOrderDto;
import com.endesyc.project_store.Entity.DetailOrder;
import com.endesyc.project_store.Mapper.DetailOrderMapper;
import com.endesyc.project_store.Repository.DetailOrderRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;



@AllArgsConstructor
@Setter
@Getter
@Service
public class DetailOrderServiceImpl implements DetailOrderService{


    private DetailOrderRepository detailOrderRepository;

    private DetailOrderMapper detailOrderMapper;
    @Override
    public DetailOrder getById(Integer id) {
        return detailOrderRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Detail order not found"));
    }

    @Override
    public DetailOrder create(DetailOrderDto dto) {
        DetailOrder detail=detailOrderMapper.fromDto(dto);
        return detailOrderRepository.save(detail);
    }

    @Override
    public Page<DetailOrder> getDetail(Pageable pageable) {
        return detailOrderRepository.findAll(pageable);
    }

    @Override
    public DetailOrder updateDetail(Integer id, DetailOrderDto dto) {
        DetailOrder detail=detailOrderMapper.updateDto(id,dto);
        return detailOrderRepository.save(detail);
    }

    @Override
    public void deleteDetail(Integer id) {

        DetailOrder detailFound=detailOrderRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Not found detail order"));
        detailOrderRepository.deleteById(id);

    }

}
