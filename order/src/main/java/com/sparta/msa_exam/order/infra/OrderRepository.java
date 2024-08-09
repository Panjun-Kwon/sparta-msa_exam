package com.sparta.msa_exam.order.infra;

import com.sparta.msa_exam.order.domain.*;
import org.springframework.data.jpa.repository.*;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
