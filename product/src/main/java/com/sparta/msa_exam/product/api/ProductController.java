package com.sparta.msa_exam.product.api;

import com.sparta.msa_exam.product.api.dto.*;
import com.sparta.msa_exam.product.app.*;
import lombok.*;
import org.springframework.validation.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/products")
    public AddProductRes addProduct(@RequestBody @Validated AddProductReq req) {
        Long product_id = productService.addProduct(req);
        return new AddProductRes(product_id);
    }

    @GetMapping("/products")
    public List<GetProductRes> getProductAll() {
        List<GetProductRes> products = productService.getProductAll();
        return products;
    }
}
