package com.sparta.msa_exam.order.api.dto;

import com.sparta.msa_exam.order.domain.*;
import lombok.*;

import java.io.*;
import java.util.*;
import java.util.stream.*;

@Getter
@NoArgsConstructor
public class GetOrderRes implements Serializable {

    private Long order_id;
    private List<Long> product_ids = new ArrayList<>();

    public GetOrderRes(Long order_id, List<Long> product_ids) {
        this.order_id = order_id;
        this.product_ids = product_ids;
    }

    public static GetOrderRes fromEntity(Order order) {
        List<Long> product_ids = order.getProduct_ids().stream().map(OrderProduct::getProduct_id).collect(Collectors.toList());
        GetOrderRes result = new GetOrderRes(order.getOrder_id(), product_ids);
        return result;
    }
}
