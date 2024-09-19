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
    private String openingHours;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private String createdBy;
    private String updatedBy;

}
