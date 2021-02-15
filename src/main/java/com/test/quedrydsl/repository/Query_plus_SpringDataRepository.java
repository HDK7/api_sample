package com.test.quedrydsl.repository;

import com.test.quedrydsl.entity.Gateway;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Query_plus_SpringDataRepository extends JpaRepository<Gateway, Integer>, QuerydslRepository {
        Gateway findById(Long id);
}
