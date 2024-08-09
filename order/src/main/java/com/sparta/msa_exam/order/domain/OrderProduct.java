package com.sparta.msa_exam.order.domain;

import jakarta.persistence.*;
import lombok.*;

import static jakarta.persistence.GenerationType.*;
import static lombok.AccessLevel.*;

@Entity
@Table(name = "order_products")
@NoArgsConstructor(access = PROTECTED)
@Getter
public class OrderProduct {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "order_product_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Order order;
    private Long product_id;

    public OrderProduct(Long product_id) {
        this.product_id = product_id;
    }

    public void addToOrder(Order order) {
        this.order = order;
        order.addOrderProduct(this);
    }
}
