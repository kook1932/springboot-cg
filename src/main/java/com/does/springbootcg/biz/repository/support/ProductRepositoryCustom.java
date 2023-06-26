package com.does.springbootcg.biz.repository.support;

import com.does.springbootcg.biz.domain.Product;

import java.util.List;

public interface ProductRepositoryCustom {

	List<Product> findByName(String name);

}
