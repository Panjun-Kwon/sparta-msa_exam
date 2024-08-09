package com.sparta.msa_exam.product.api.dto;

import com.sparta.msa_exam.product.domain.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Getter
public class AddProductReq {
    @NotNull(message = "상품 이름 필수")
    private String name;
    @Min(value = 0, message = "공급가 최소 0")
    private Integer supply_price;

    public Product toEntity() {
        return new Product(this.name, this.supply_price);
    }
}
