package com.does.springbootcg.biz.repository;

import com.does.springbootcg.biz.domain.Producer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProducerRepository extends JpaRepository<Producer, Long> {
}
