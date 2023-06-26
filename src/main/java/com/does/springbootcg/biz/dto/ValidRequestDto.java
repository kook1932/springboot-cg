package com.does.springbootcg.biz.dto;

import com.does.springbootcg.annotation.Telephone;
import com.does.springbootcg.biz.domain.group.ValidationGroup1;
import com.does.springbootcg.biz.domain.group.ValidationGroup2;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@NoArgsConstructor @AllArgsConstructor
@Data @Builder
public class ValidRequestDto {

	@NotBlank
	private String name;

	@Email
	private String email;

	@Telephone
	private String phoneNumber;

	@Min(value = 20, groups = ValidationGroup1.class) @Max(value = 40, groups = ValidationGroup1.class)
	private int age;

	@Size(min = 0, max = 40)
	private String description;

	@Positive(groups = ValidationGroup2.class)
	private int count;

	@AssertTrue
	private boolean booleanCheck;
}
