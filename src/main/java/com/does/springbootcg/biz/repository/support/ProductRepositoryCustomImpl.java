package com.does.springbootcg.biz.repository.support;

import com.does.springbootcg.biz.domain.Product;
import com.does.springbootcg.biz.domain.QProduct;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductRepositoryCustomImpl extends QuerydslRepositorySupport implements ProductRepositoryCustom {

	public ProductRepositoryCustomImpl() {
		super(Product.class);
	}

	@Override
	public List<Product> findByName(String name) {
		QProduct product = QProduct.product;

		List<Product> products = from(product)
				.where(product.name.eq(name))
				.select(product)
				.fetch();

		return products;
	}
}
