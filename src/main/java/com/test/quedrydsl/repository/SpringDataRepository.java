package com.test.quedrydsl.repository;

import com.test.quedrydsl.entity.Gateway;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpringDataRepository extends JpaRepository<Gateway, Integer> {
        Gateway findById(Long id);
}
