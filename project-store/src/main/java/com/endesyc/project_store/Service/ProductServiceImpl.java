package com.endesyc.project_store.Service;

import com.endesyc.project_store.Dto.ProductDto;
import com.endesyc.project_store.Entity.Product;
import com.endesyc.project_store.Mapper.ProductMapper;
import com.endesyc.project_store.Repository.ProductRepository;
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
public class ProductServiceImpl implements ProductService{

    private ProductRepository productRepository;

    private ProductMapper productMapper;
    @Override
    public Product getById(Integer id) {
        return productRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Product not found"));
    }


    @Override
    public Product create(ProductDto dto) {
        Product product=productMapper.fromDto(dto);
        return productRepository.save(product);
    }

    @Override
    public Page<Product> getProduct(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Product updateProduct(Integer id, ProductDto dto) {
        Product product=new Product();
        if(this.getById(id)!=null) {
            product = productMapper.updateDto(id, dto);
        }
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Integer id) {
        Product productFound= productRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Not found Product"));
        productRepository.deleteById(id);
    }


    @Override
    public Product getByName(String name) {
        return productRepository.findByName(name).orElseThrow(()->new EntityNotFoundException("Product not found"));
    }


}
