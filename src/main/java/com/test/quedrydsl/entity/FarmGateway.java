package com.test.quedrydsl.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.criteria.CriteriaBuilder;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Getter @Setter
public class FarmGateway {

    @Id
    @GeneratedValue
    private Long id;
    private Long farmId;
    private String name;
    private String ip;
    private Integer port;
    private Integer readTerm;
    private Date installDate;
    private String manager;
    private Character useYn;
    private String regId;
    private Timestamp regDate;
    private String modId;
    private Timestamp modDate;
    private String note;
    private Integer installCost;
    private Date warrantyEndDate;
    private Character delYn;
    private Character statusChangedYn;
    private Integer protocolId;
    private String classCode;


    public FarmGateway(){}
}