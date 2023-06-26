package com.does.springbootcg.biz.repository;

import com.does.springbootcg.biz.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
