package com.does.springbootcg.biz.repository;

import com.does.springbootcg.biz.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
	List<Product> findByName(String name, Sort sort);
	Page<Product> findByName(String name, Pageable pageable);
}
