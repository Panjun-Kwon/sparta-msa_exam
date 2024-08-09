package com.sparta.msa_exam.product.domain;

import jakarta.persistence.*;
import lombok.*;

import static jakarta.persistence.GenerationType.*;
import static lombok.AccessLevel.*;

@Entity
@Table(name = "products")
@NoArgsConstructor(access = PROTECTED)
@Getter
public class Product {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "product_id")
    private Long product_id;

    private String name;
    private Integer supply_price;

    public Product(String name, Integer supply_price) {
        this.name = name;
        this.supply_price = supply_price;
    }
}
