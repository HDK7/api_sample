package com.test.quedrydsl.repository;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.test.quedrydsl.dto.GatewayDto;
import com.test.quedrydsl.dto.QGatewayDto;
import com.test.quedrydsl.entity.Gateway;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import static com.test.quedrydsl.entity.QGateway.gateway;

@Repository
public class QuerydslRepositoryImpl implements QuerydslRepository {

    private final EntityManager em;
    private final JPAQueryFactory queryFactory;


    public QuerydslRepositoryImpl(EntityManager em, JPAQueryFactory queryFactory) {
        this.em = em;
        this.queryFactory = new JPAQueryFactory(em);
    }

    public GatewayDto findOne(Gateway condition){
        return queryFactory
                .select(new QGatewayDto(
                        gateway.name))
                .from(gateway)
                .where(
                        idEq(condition.getId()),
                        nameContains(condition.getName()),
                        ipContains(condition.getIp()),
                        portEq(condition.getPort())
                )
                .fetchOne();
    }

    private BooleanExpression idEq(Long id){
        return id != null ? gateway.id.eq(id) : null;
    }
    private BooleanExpression nameContains(String name){
        return name != null ? gateway.name.contains(name) : null;
    }
    private BooleanExpression ipContains(String ip){
        return ip != null ? gateway.ip.contains(ip) : null;
    }
    private BooleanExpression portEq(Integer port){
        return port != null ? gateway.port.eq(port) : null;
    }
}
