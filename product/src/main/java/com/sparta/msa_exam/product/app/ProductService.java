package com.sparta.msa_exam.product.app;

import com.sparta.msa_exam.product.api.dto.*;
import com.sparta.msa_exam.product.domain.*;
import com.sparta.msa_exam.product.infra.*;
import lombok.*;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

import java.util.*;
import java.util.stream.*;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    @CachePut(cacheNames = "productCache", key = "#result")
    @CacheEvict(cacheNames = "productAllCache", allEntries = true)
    @Transactional
    public Long addProduct(AddProductReq req) {
        Product product = productRepository.save(req.toEntity());
        Long productId = product.getProduct_id();
        return productId;
    }

    @Cacheable(value = "productAllCache", key = "methodName")
    @Transactional(readOnly = true)
    public List<GetProductRes> getProductAll() {
        List<Product> products = productRepository.findAll();
        List<GetProductRes> result = products.stream().map(GetProductRes::fromEntity).collect(Collectors.toList());
        return result;
    }
}
