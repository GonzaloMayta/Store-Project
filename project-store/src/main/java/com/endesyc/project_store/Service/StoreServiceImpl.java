package com.endesyc.project_store.Service;
import com.endesyc.project_store.Dto.StoreDto;
import com.endesyc.project_store.Entity.Store;
import com.endesyc.project_store.Mapper.StoreMapper;
import com.endesyc.project_store.Repository.StoreRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class StoreServiceImpl implements StoreService{

    private StoreRepository storeRepository;

    private StoreMapper storeMapper;
    @Override
    public Store getById(Integer id) {
        return storeRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Store not found"));
    }


    @Override
    public Store create(StoreDto dto) {
        Store category=storeMapper.fromDto(dto);
        return storeRepository.save(category);
    }

    @Override
    public Page<Store> getStore(Pageable pageable) {
        return storeRepository.findAll(pageable);
    }

    @Override
    public Store updateStore(Integer id,StoreDto dto) {
        Store store=storeMapper.updateDto(id,dto);
        return storeRepository.save(store);
    }

    @Override
    public void deleteStore(Integer id) {

        Store storeFound= storeRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Not found store"));
        storeRepository.deleteById(id);

    }
}
