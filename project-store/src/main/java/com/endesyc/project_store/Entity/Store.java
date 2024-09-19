package com.endesyc.project_store.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.sql.Timestamp;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;
    @Column(length = 50)
    private String name;
    @Column(length = 150)
    private String address;
    @Column(length = 150)
    private String city;
    @Column(name = "opening_hours", length = 50)
    private String openingHours;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", shape = JsonFormat.Shape.STRING)
    @Column(name="created_at")
    private Timestamp createdAt;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", shape = JsonFormat.Shape.STRING)
    @Column(name="updated_at")
    private Timestamp updatedAt;
    @Column(length = 255, name = "created_by")
    private String createdBy;
    @Column(length = 255, name="updated_by")
    private String updatedBy;

    @OneToMany(mappedBy = "storeId")
    @JsonIgnoreProperties({"storeId"})
    private List<Order> orderId;

}
