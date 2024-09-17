package com.endesyc.project_store.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;


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
    private Timestamp created_at;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", shape = JsonFormat.Shape.STRING)
    private Timestamp updated_at;
    @Column(length = 255)
    private String created_by;
    @Column(length = 255)
    private String updated_by;

    @ManyToOne
    @JoinColumn(name="category_id", nullable = false)
    private Category category_id;
}
