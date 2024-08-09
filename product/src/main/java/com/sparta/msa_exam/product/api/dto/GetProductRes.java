package com.sparta.msa_exam.product.api.dto;

import com.sparta.msa_exam.product.domain.*;
import jakarta.ws.rs.*;
import lombok.*;

import java.io.*;

@Getter
@NoArgsConstructor
public class GetProductRes implements Serializable {
    private Long product_id;
    private String name;
    private Integer supply_price;

    public GetProductRes(Product product) {
        this.product_id = product.getProduct_id();
        this.name = product.getName();
        this.supply_price = product.getSupply_price();
    }

    public static GetProductRes fromEntity(Product product) {
        return new GetProductRes(product);
    }
}
