package com.test.quedrydsl.controller;

import com.test.quedrydsl.entity.FarmGateway;
import com.test.quedrydsl.repository.farmgateway.FarmgatewayDslRepositoryImpl;
import com.test.quedrydsl.repository.farmgateway.FarmgatewayRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class FarmGatewayController {

    private final FarmgatewayDslRepositoryImpl farmgatewayDslRepository;
    private final FarmgatewayRepository farmgatewayRepository;

//    @PostMapping("/gateway/{id}")
//    public Gateway findGateway(@PathVariable("id") Long id){
//        Gateway gateway = springDataRepository.findById(id);
//        return gateway;
//    }

//    @GetMapping("/farmgateway")
//    public Page<FarmGateway> getFarmGateways(FarmGateway condition, Pageable pageable) {
//        return farmgatewayDslRepository.findFarmgateways(condition, pageable);
//    }
//
//    @GetMapping("/farmgateway/jpa")
//    public Page<FarmGateway> getFarmGateways2(FarmGateway condition, Pageable pageable){
//        return farmgatewayJpaRepository.findAllByPort(condition.getPort(), pageable);
//    }

    @GetMapping("/farmgateway")
    public Page<FarmGateway> getFarmGateways(FarmGateway condition, Pageable pageable) {
        return farmgatewayRepository.findFarmgateways(condition, pageable);
    }

    @GetMapping("/farmgateway/jpa")
    public Page<FarmGateway> getFarmGateways2(FarmGateway condition, Pageable pageable){
        return farmgatewayRepository.findAllByPort(condition.getPort(), pageable);
    }

}
