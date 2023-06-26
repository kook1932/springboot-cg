package com.does.springbootcg.biz.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@ToString(callSuper = true) @EqualsAndHashCode(callSuper = true)
@Getter @Setter @NoArgsConstructor
@Entity @Table(name = "producer")
public class Producer extends BaseEntity {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;

	private String code;

	@ToString.Exclude
	@ManyToMany
	private List<Product> products = new ArrayList<>();

	public void addProduct(Product product) {
		products.add(product);
	}
}
