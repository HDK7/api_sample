package com.test.quedrydsl.controller;

import com.test.quedrydsl.dto.GatewayDto;
import com.test.quedrydsl.entity.Gateway;
import com.test.quedrydsl.repository.QuerydslRepository;
import com.test.quedrydsl.repository.SpringDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GatewayController {

    private final SpringDataRepository springDataRepository;
    private final QuerydslRepository querydslRepository;

    @GetMapping("/gateway/{id}")
    public Gateway findGateway(@PathVariable("id") Long id){
        Gateway gateway = springDataRepository.findById(id);
        return gateway;
    }

    @GetMapping("/gateway/querydsl")
    public GatewayDto findGateway2(Gateway condition){
        GatewayDto gatewayDto = querydslRepository.findOne(condition);
        System.out.println(condition.toString());
        System.out.println(gatewayDto.toString());
        return gatewayDto;
    }

}
