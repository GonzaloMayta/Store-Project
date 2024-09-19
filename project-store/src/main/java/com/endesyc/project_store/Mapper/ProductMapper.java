package com.endesyc.project_store.Mapper;
import com.endesyc.project_store.Dto.ProductDto;
import com.endesyc.project_store.Entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public Product fromDto(ProductDto dto){
        Product product= new Product();
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setStock(dto.getStock());
        product.setPrice(dto.getPrice());
        product.setActive(dto.getActive());
        product.setCreatedAt(dto.getCreatedAt());
        product.setUpdatedAt(dto.getUpdatedAt());
        product.setCreatedBy(dto.getCreatedBy());
        product.setUpdatedBy(dto.getUpdatedBy());
        return product;
    }


    public Product updateDto(Integer id,ProductDto dto){
        Product product= new Product();
        product.setId(id);
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setStock(dto.getStock());
        product.setPrice(dto.getPrice());
        product.setActive(dto.getActive());
        product.setCreatedAt(dto.getCreatedAt());
        product.setUpdatedAt(dto.getUpdatedAt());
        product.setCreatedBy(dto.getCreatedBy());
        product.setUpdatedBy(dto.getUpdatedBy());

        return product;
    }
}
