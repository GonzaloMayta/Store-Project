package com.endesyc.project_store.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Date;

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
    @Column(length = 255)
    private  String shipping_address;
    private  Boolean is_delivery;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", shape = JsonFormat.Shape.STRING)
    private Timestamp created_at;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", shape = JsonFormat.Shape.STRING)
    private   Timestamp updated_at;
    @Column(length = 255)
    private  String created_by;
    @Column(length = 255)
    private  String updated_by;

    @ManyToOne
    @JoinColumn(name="stored_id")
    private Store store_id;

}
