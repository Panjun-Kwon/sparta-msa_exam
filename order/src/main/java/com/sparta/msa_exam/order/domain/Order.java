package com.sparta.msa_exam.order.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.*;

import static jakarta.persistence.GenerationType.*;
import static lombok.AccessLevel.*;

@Entity
@Table(name = "orders")
@NoArgsConstructor(access = PROTECTED)
@Getter
public class Order {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "order_id")
    private Long order_id;

    private String name;
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderProduct> product_ids = new ArrayList<>();

    public Order(String name) {
        this.name = name;
    }

    public void addOrderProduct(OrderProduct orderProduct) {
        this.product_ids.add(orderProduct);
    }
}
