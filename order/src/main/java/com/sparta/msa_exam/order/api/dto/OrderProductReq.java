package com.sparta.msa_exam.order.api.dto;

import com.sparta.msa_exam.order.domain.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.validation.annotation.*;

@Getter
public class OrderProductReq {

    @NotNull
    private Long product_id;

    public OrderProduct toEntity() {
        return new OrderProduct(this.product_id);
    }
}
