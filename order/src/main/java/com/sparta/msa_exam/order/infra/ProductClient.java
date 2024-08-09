package com.sparta.msa_exam.order.infra;

import com.sparta.msa_exam.order.api.dto.*;
import org.springframework.cloud.openfeign.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@FeignClient("product-service")
public interface ProductClient {

    @GetMapping("/products")
    List<GetProductRes> getProductAll();
}
