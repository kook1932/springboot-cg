package com.does.springbootcg.biz.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Builder
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
@Table(name = "product")
@Entity
public class Product extends BaseEntity {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long number;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private Integer price;

	@Column(nullable = false)
	private Integer stock;

	@ToString.Exclude
	@OneToOne(mappedBy = "product")
	private ProductDetail productDetail;

	@ToString.Exclude
	@JoinColumn(name = "provider_id")
	@ManyToOne
	private Provider provider;

	@ToString.Exclude
	@ManyToMany
	private List<Producer> producers = new ArrayList<>();

	public void addProducer(Producer producer) {
		producers.add(producer);
	}

}
