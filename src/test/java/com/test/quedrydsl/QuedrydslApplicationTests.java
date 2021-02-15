package com.test.quedrydsl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.test.quedrydsl.entity.Gateway;
import com.test.quedrydsl.repository.SpringDataRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@SpringBootTest
@Transactional
class QuedrydslApplicationTests {

	@Autowired
	EntityManager em;

	@Autowired
	SpringDataRepository springDataRepository;

//	@Test
//	void contextLoads() {
//		Gateway gateway = new Gateway();
//		em.persist(gateway);
//
//		JPAQueryFactory query = new JPAQueryFactory(em);
//		QGateway qGateway = QGateway.gateway;
//	}

	@Test
	void springDataJPA(){
		Long id = Long.valueOf(1);
		Gateway gateway = springDataRepository.findById(id);
		System.out.println(gateway.toString());
	}


}
