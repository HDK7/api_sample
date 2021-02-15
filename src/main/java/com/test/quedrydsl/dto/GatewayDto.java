package com.test.quedrydsl.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GatewayDto {
    private String name;

    @QueryProjection
    public GatewayDto(String name){
        this.name = name;
    }
}
