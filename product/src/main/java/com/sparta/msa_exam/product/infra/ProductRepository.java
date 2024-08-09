package com.sparta.msa_exam.product.infra;

import com.sparta.msa_exam.product.domain.*;
import org.springframework.data.jpa.repository.*;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
