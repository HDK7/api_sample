package com.test.quedrydsl.repository;

import com.test.quedrydsl.dto.GatewayDto;
import com.test.quedrydsl.entity.Gateway;

public interface QuerydslRepository {
    GatewayDto findOne(Gateway condition);
}
