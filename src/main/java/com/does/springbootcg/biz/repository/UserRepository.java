package com.does.springbootcg.biz.repository;

import com.does.springbootcg.biz.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
	User getByUid(String uid);
}
