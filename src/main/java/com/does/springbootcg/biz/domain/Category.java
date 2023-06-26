package com.does.springbootcg.biz.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@ToString @EqualsAndHashCode
@Getter @Setter @NoArgsConstructor
@Entity @Table(name = "category")
public class Category {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	public Long id;

	@Column(unique = true)
	private String code;

	private String name;

	@JoinColumn(name = "category_id")
	@OneToMany(fetch = FetchType.EAGER)
	private List<Product> products = new ArrayList<>();
}
