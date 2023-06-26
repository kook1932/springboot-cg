package com.does.springbootcg.biz.repository;

import com.does.springbootcg.biz.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface QProductRepository extends JpaRepository<Product, Long>, QuerydslPredicateExecutor {
}
