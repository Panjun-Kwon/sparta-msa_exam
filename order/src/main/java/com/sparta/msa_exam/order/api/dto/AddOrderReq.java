package com.sparta.msa_exam.order.api.dto;

import com.sparta.msa_exam.order.domain.*;
import jakarta.validation.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.validation.annotation.*;

import java.util.*;

@Getter
public class AddOrderReq {

    @NotNull
    private String name;
    @Valid
    private List<OrderProductReq> productIds;

    public Order toEntity() {
        Order order = new Order(this.name);
        productIds.stream().forEach(productId -> {
            OrderProduct orderProduct = productId.toEntity();
            orderProduct.addToOrder(order);
        });
        return order;
    }

}
