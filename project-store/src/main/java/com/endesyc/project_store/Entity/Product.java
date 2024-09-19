package com.endesyc.project_store.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;
    @Column(length = 255)
    private String name;
    @Column(length = 255)
    private String description;
    private Integer stock;
    private Double price;
    private Boolean active;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", shape = JsonFormat.Shape.STRING)
    @Column(name = "created_at")
    private Timestamp createdAt;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", shape = JsonFormat.Shape.STRING)
    @Column(name = "updated_at")
    private Timestamp updatedAt;
    @Column(length = 255,name = "created_by")
    private String createdBy;
    @Column(length = 255, name = "updated_by")
    private String updatedBy;

    @ManyToOne
    @JoinColumn(name="category_id")
    private Category categoryId;

    @OneToMany(mappedBy = "productId")
    @JsonIgnoreProperties({"productId","detailOrderList","orderId","product"})
    private List<DetailOrder> detailOrderList;
}
