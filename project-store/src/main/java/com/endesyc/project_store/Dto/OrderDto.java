package com.endesyc.project_store.Dto;

import com.endesyc.project_store.Entity.Store;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class OrderDto {

    private Integer   id;
    private String    name;
    private Date      date;
    private String    shippingAddress;
    private Boolean   isDelivery;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private  String createdBy;
    private  String updatedBy;
    private Store storeId;

}
