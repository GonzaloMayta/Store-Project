package com.endesyc.project_store.Service;
import com.endesyc.project_store.Dto.StoreDto;
import com.endesyc.project_store.Entity.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StoreService {

    Store getById(Integer id);
    Store create(StoreDto dto);
    Page<Store> getStore(Pageable pageable);
    Store updateStore(Integer id,StoreDto dto);
    void deleteStore(Integer id);
}
