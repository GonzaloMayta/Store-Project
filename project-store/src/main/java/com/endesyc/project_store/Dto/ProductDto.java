package com.endesyc.project_store.Dto;


import com.endesyc.project_store.Entity.Category;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Setter
@Getter
@NoArgsConstructor
public class ProductDto {

    private Integer id;
    private String name;
    private String description;
    private Integer stock;
    private Double price;
    private Boolean active;
    private Timestamp created_at;
    private Timestamp updated_at;
    private String created_by;
    private String updated_by;
    private Category category_id;
}
