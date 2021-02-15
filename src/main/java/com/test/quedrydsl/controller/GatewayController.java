package com.test.quedrydsl.controller;

import com.test.quedrydsl.dto.GatewayDto;
import com.test.quedrydsl.entity.Gateway;
import com.test.quedrydsl.repository.QuerydslRepositoryImpl;
import com.test.quedrydsl.repository.Query_plus_SpringDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GatewayController {

    private final Query_plus_SpringDataRepository query_plus_springDataRepository;

    @GetMapping("/gateway/{id}")
    public Gateway findGateway(@PathVariable("id") Long id){
        return query_plus_springDataRepository.findById(id);
    }

    @GetMapping("/gateway/querydsl")
    public GatewayDto findGateway2(Gateway condition){
        return query_plus_springDataRepository.findOne(condition);
    }

}
