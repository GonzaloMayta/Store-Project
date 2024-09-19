package com.endesyc.project_store.Mapper;
import com.endesyc.project_store.Dto.StoreDto;
import com.endesyc.project_store.Entity.Store;
import org.springframework.stereotype.Component;

@Component
public class StoreMapper {

    public Store fromDto(StoreDto dto){
        Store store= new Store();
        store.setName(dto.getName());
        store.setAddress(dto.getAddress());
        store.setCity(dto.getCity());
        store.setOpeningHours(dto.getOpeningHours());
        store.setCreatedAt(dto.getCreatedAt());
        store.setUpdatedAt(dto.getUpdatedAt());
        store.setCreatedBy(dto.getCreatedBy());
        store.setUpdatedBy(dto.getUpdatedBy());

        return store;
    }


    public Store updateDto(Integer id,StoreDto dto){
        Store store= new Store();
        store.setId(id);
        store.setName(dto.getName());
        store.setAddress(dto.getAddress());
        store.setCity(dto.getCity());
        store.setOpeningHours(dto.getOpeningHours());
        store.setCreatedAt(dto.getCreatedAt());
        store.setUpdatedAt(dto.getUpdatedAt());
        store.setCreatedBy(dto.getCreatedBy());
        store.setUpdatedBy(dto.getUpdatedBy());

        return store;
    }
}
