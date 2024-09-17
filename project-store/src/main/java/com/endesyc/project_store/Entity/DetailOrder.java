package com.endesyc.project_store.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "details_orders")
public class DetailOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;
    @Column(nullable = false)
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name="order_id", nullable = false)
    private Order order_id;

    @ManyToOne
    @JoinColumn(name="product_id", nullable = false)
    private Product product_id;

}
