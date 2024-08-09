package com.sparta.msa_exam.order.api.dto;

import lombok.*;

@Getter
@NoArgsConstructor
public class GetProductRes {
    private Long product_id;
    private String name;
    private Integer supply_price;
}
