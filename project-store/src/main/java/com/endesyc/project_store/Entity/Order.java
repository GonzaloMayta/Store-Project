package com.endesyc.project_store.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;
    @Column(length = 255)
    private  String name;
    private Date date;
    @Column(length = 255,name = "shipping_address")
    private  String shippingAddress;
    @Column(name="is_delivery")
    private  Boolean isDelivery;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", shape = JsonFormat.Shape.STRING)
    @Column(name="created_at")
    private Timestamp createdAt;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", shape = JsonFormat.Shape.STRING)
    @Column(name="updated_at")
    private   Timestamp updatedAt;
    @Column(length = 255, name="created_by")
    private  String createdBy;
    @Column(length = 255, name ="updated_by")
    private  String updatedBy;

    @ManyToOne
    @JoinColumn(name="stored_id",nullable = false)
    private Store storeId;

    @OneToMany(mappedBy = "orderId")
    @JsonIgnoreProperties({"orderId","detailOrderList","storeId","categoryId", "storeId"})
    private List<DetailOrder> detailOrderList;

}
