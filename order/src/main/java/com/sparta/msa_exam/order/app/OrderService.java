package com.sparta.msa_exam.order.app;

import com.sparta.msa_exam.order.api.dto.*;
import com.sparta.msa_exam.order.domain.*;
import com.sparta.msa_exam.order.domain.Order;
import com.sparta.msa_exam.order.infra.*;
import io.github.resilience4j.circuitbreaker.annotation.*;
import lombok.*;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

import java.util.*;
import java.util.stream.*;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductClient productClient;

    @Transactional
    public Long addOrder(AddOrderReq req) {
        Order order = orderRepository.save(req.toEntity());
        return order.getOrder_id();
    }

    @CircuitBreaker(name = "addOrderProductToOrder", fallbackMethod = "fallbackAddOrderProductToOrder")
    @Transactional
    public void addOrderProductToOrder(Long orderId, OrderProductReq req) {
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new NullPointerException(orderId + " 주문 없음"));
        OrderProduct orderProduct = req.toEntity();

        List<GetProductRes> products = productClient.getProductAll();
        List<Long> productIds = new ArrayList<>();
        products.stream().map(product -> productIds.add(product.getProduct_id())).collect(Collectors.toList());
        Long productId = orderProduct.getProduct_id();
        if (!productIds.contains(productId)) {
            throw new IllegalArgumentException(productId + " 상품 없음");
        }

        orderProduct.addToOrder(order);
    }

    public void fallbackAddOrderProductToOrder(Throwable t) {
        System.out.println("주문에 상품 추가 실패");
    }

    @Cacheable(cacheNames = "orderCache", key = "args[0]")
    @Transactional(readOnly = true)
    public GetOrderRes getOrder(Long orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new NullPointerException(orderId + " 주문 없음"));
        return GetOrderRes.fromEntity(order);
    }
}
