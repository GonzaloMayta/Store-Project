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
        store.setOpening_hours(dto.getOpening_hours());
        store.setCreated_at(dto.getCreated_at());
        store.setUpdated_at(dto.getUpdated_at());
        store.setCreated_by(dto.getCreated_by());
        store.setUpdated_by(dto.getUpdated_by());

        return store;
    }


    public Store updateDto(Integer id,StoreDto dto){
        Store store= new Store();
        store.setId(id);
        store.setName(dto.getName());
        store.setAddress(dto.getAddress());
        store.setCity(dto.getCity());
        store.setOpening_hours(dto.getOpening_hours());
        store.setCreated_at(dto.getCreated_at());
        store.setUpdated_at(dto.getUpdated_at());
        store.setCreated_by(dto.getCreated_by());
        store.setUpdated_by(dto.getUpdated_by());

        return store;
    }
}
