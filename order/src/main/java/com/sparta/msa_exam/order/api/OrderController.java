package com.sparta.msa_exam.order.api;

import com.sparta.msa_exam.order.api.dto.*;
import com.sparta.msa_exam.order.app.*;
import lombok.*;
import org.springframework.cache.annotation.*;
import org.springframework.validation.annotation.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/order")
    public AddOrderRes addOrder(@RequestBody @Validated AddOrderReq req) {
        Long orderId = orderService.addOrder(req);
        return new AddOrderRes(orderId);
    }

    @PutMapping("/order/{orderId}")
    public void addOrderProduct(@PathVariable("orderId") Long orderId, @RequestBody @Validated OrderProductReq req) {
        orderService.addOrderProductToOrder(orderId, req);
    }

    @GetMapping("/order/{orderId}")
    public GetOrderRes getOrder(@PathVariable("orderId") Long orderId) {
        GetOrderRes order = orderService.getOrder(orderId);
        return order;
    }
}
