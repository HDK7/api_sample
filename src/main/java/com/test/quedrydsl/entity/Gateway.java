package com.test.quedrydsl.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class Gateway {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String ip;
    private Integer port;

}
