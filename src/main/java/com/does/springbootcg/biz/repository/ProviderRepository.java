package com.does.springbootcg.biz.repository;

import com.does.springbootcg.biz.domain.Provider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProviderRepository extends JpaRepository<Provider, Long> {
}
