package com.cosium.spring.data.jpa.entity.graph.repository.support;

import javax.persistence.EntityManager;
import java.io.Serializable;

import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.JPQLQuery;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.QueryDslJpaRepository;
import org.springframework.data.querydsl.EntityPathResolver;

/**
 * Created on 05/12/16.
 *
 * @author Reda.Housni-Alaoui
 */
class EntityGraphAwareQueryDslJpaRepository<T, ID extends Serializable> extends QueryDslJpaRepository<T, ID> {

	public EntityGraphAwareQueryDslJpaRepository(JpaEntityInformation<T, ID> entityInformation, EntityManager entityManager) {
		super(entityInformation, entityManager);
	}

	public EntityGraphAwareQueryDslJpaRepository(JpaEntityInformation<T, ID> entityInformation, EntityManager entityManager, EntityPathResolver resolver) {
		super(entityInformation, entityManager, resolver);
	}

	@Override
	protected JPQLQuery<?> createCountQuery(Predicate predicate) {
		return CountQueryDetector.proxy(super.createCountQuery(predicate));
	}
}
