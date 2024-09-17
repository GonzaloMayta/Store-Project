package com.endesyc.project_store.Service;

import com.endesyc.project_store.Dto.ProductDto;
import com.endesyc.project_store.Entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {

    Product getById(Integer id);
    Product create(ProductDto dto);
    Page<Product> getProduct(Pageable pageable);
    Product updateProduct(Integer id, ProductDto dto);
    void deleteProduct(Integer id);

    Product getByName(String name);
}
