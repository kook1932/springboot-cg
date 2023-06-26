package com.does.springbootcg.biz.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@ToString(callSuper = true) @EqualsAndHashCode(callSuper = true)
@Getter @Setter @NoArgsConstructor
@Entity @Table(name = "provider")
public class Provider extends BaseEntity {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;

	private String name;

	@ToString.Exclude
	@OneToMany(mappedBy = "provider", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	private List<Product> productList = new ArrayList<>();
}
