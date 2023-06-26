package com.does.springbootcg.biz.domain;

import lombok.*;

import javax.persistence.*;

@ToString(callSuper = true) @EqualsAndHashCode(callSuper = true)
@Getter @Setter @NoArgsConstructor
@Table(name = "product_detail")
@Entity
public class ProductDetail extends BaseEntity{

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;

	private String description;

	@OneToOne
	@JoinColumn(name = "product_number")
	private Product product;

}
