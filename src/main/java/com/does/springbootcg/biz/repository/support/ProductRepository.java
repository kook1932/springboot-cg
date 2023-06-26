package com.does.springbootcg.biz.repository.support;

import com.does.springbootcg.biz.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("productRepositorySupport")
public interface ProductRepository extends JpaRepository<Product, Long>, ProductRepositoryCustom {
}
