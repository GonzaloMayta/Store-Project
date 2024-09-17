package com.endesyc.project_store.Dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@NoArgsConstructor
@Getter
@Setter
public class StoreDto {

    private Integer id;
    private String  name;
    private String  address;
    private String city;
    private String opening_hours;
    private Timestamp created_at;
    private Timestamp updated_at;
    private String created_by;
    private String updated_by;

}
