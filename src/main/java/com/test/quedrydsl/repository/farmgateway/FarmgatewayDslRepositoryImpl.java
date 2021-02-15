package com.test.quedrydsl.repository.farmgateway;

import com.querydsl.core.QueryResults;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.test.quedrydsl.dto.GatewayDto;
import com.test.quedrydsl.dto.QGatewayDto;
import com.test.quedrydsl.entity.FarmGateway;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import static com.test.quedrydsl.entity.QFarmGateway.farmGateway;

@Repository
public class FarmgatewayDslRepositoryImpl implements FarmgatewayDslRepository{

    private final EntityManager em;
    private final JPAQueryFactory queryFactory;


    public FarmgatewayDslRepositoryImpl(EntityManager em, JPAQueryFactory queryFactory) {
        this.em = em;
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public Page<FarmGateway> findFarmgateways(FarmGateway condition, Pageable pageable){
        QueryResults<FarmGateway> results = queryFactory
                .selectFrom(farmGateway)
                .where(
                        idEq(condition.getId()),
                        farmIdEq(condition.getFarmId()),
                        nameContains(condition.getName()),
                        ipContains(condition.getIp()),
                        portEq(condition.getPort()),
                        readTermEq(condition.getReadTerm()),
                        installDateEq(condition.getInstallDate()),
                        managerContains(condition.getManager()),
                        useYnEq(condition.getUseYn()),
                        regIdContains(condition.getRegId()),
                        regDateEq(condition.getRegDate()),
                        modIdContains(condition.getModId()),
                        modDateEq(condition.getModDate()),
                        noteContains(condition.getNote()),
                        installCostEq(condition.getInstallCost()),
                        warrantyEndDateEq(condition.getWarrantyEndDate()),
                        delYnEq(condition.getDelYn()),
                        statusChangedYnEq(condition.getStatusChangedYn()),
                        protocolIdEq(condition.getProtocolId()),
                        classCodeContains(condition.getClassCode())
                )
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetchResults();

        List<FarmGateway> content = results.getResults();
        long total = results.getTotal();

        return new PageImpl<>(content, pageable, total);
    }

    private BooleanExpression idEq(Long id) {return id != null ? farmGateway.id.eq(id) : null; }
    private BooleanExpression farmIdEq(Long farmId) { return farmId != null ? farmGateway.farmId.eq(farmId) : null;}
    private BooleanExpression nameContains(String name) { return name != null ? farmGateway.name.contains(name) : null;}
    private BooleanExpression ipContains(String ip) { return ip != null ? farmGateway.ip.contains(ip) : null;}
    private BooleanExpression portEq(Integer port) { return port != null ? farmGateway.port.eq(port) : null;}
    private BooleanExpression readTermEq(Integer readTerm) { return readTerm != null ? farmGateway.readTerm.eq(readTerm) : null;}
    private BooleanExpression installDateEq(Date installDate) { return installDate != null ? farmGateway.installDate.eq(installDate) : null;}
    private BooleanExpression managerContains(String manager) { return manager != null ? farmGateway.manager.contains(manager) : null;}
    private BooleanExpression useYnEq(Character useYn) { return useYn != null ? farmGateway.useYn.eq(useYn) : null;}
    private BooleanExpression regIdContains(String regId) { return regId != null ? farmGateway.regId.contains(regId) : null;}
    private BooleanExpression regDateEq(Timestamp regDate) { return regDate != null ? farmGateway.regDate.eq(regDate) : null;}
    private BooleanExpression modIdContains(String modId) { return modId != null ? farmGateway.modId.contains(modId) : null; }
    private BooleanExpression modDateEq(Timestamp modDate) { return modDate != null ? farmGateway.modDate.eq(modDate) : null;}
    private BooleanExpression noteContains(String note) { return note != null ? farmGateway.note.eq(note) : null;}
    private BooleanExpression installCostEq(Integer installCost) { return installCost != null ? farmGateway.installCost.eq(installCost) : null;}
    private BooleanExpression warrantyEndDateEq(Date warrantyEndDate) { return warrantyEndDate != null ? farmGateway.warrantyEndDate.eq(warrantyEndDate) : null;}
    private BooleanExpression delYnEq(Character delYn) { return delYn != null ? farmGateway.delYn.eq(delYn) : null;}
    private BooleanExpression statusChangedYnEq(Character statusChangedYn) {return statusChangedYn != null ? farmGateway.delYn.eq(statusChangedYn) : null;}
    private BooleanExpression protocolIdEq(Integer protocolId) { return protocolId != null ? farmGateway.protocolId.eq(protocolId) : null;}
    private BooleanExpression classCodeContains(String classCode) { return classCode != null ? farmGateway.classCode.contains(classCode) : null;}
}
