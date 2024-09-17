package com.endesyc.project_store.Dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {

    private Integer id;
    private String name;
    private String description;
    private Timestamp created_at;
    private Timestamp updated_at;
    private String created_by;
    private String updated_by;
}
