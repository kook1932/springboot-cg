package com.does.springbootcg.biz.repository;

import com.does.springbootcg.biz.domain.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDetailRepository extends JpaRepository<ProductDetail, Long> {
}
