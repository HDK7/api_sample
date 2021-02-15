package com.test.quedrydsl.repository.farmgateway;

import com.test.quedrydsl.entity.FarmGateway;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FarmgatewayRepository extends JpaRepository<FarmGateway, Long>, FarmgatewayDslRepository{
    Page<FarmGateway> findAllByPort(Integer port, Pageable pageable);
}
