package com.test.quedrydsl.repository.farmgateway;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.test.quedrydsl.entity.FarmGateway;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;

public interface FarmgatewayDslRepository {
    Page<FarmGateway> findFarmgateways(FarmGateway condition, Pageable pageable);
}
