package com.example.demo.dao.impl.jpa.support;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.convert.QueryByExamplePredicateBuilder;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public class EasyCodeRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID>
		implements EasyCodeRepository<T, ID> {

	public EasyCodeRepositoryImpl(Class<T> domainClass, EntityManager em) {
		super(domainClass, em);
		// TODO Auto-generated constructor stub
	}

	public EasyCodeRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
		super(entityInformation, entityManager);
	}

	@Override
	public Collection<T> limit(Example<T> example, Limitable limitable) {
		Class<T> probeType = example.getProbeType();
		TypedQuery<T> query = getQuery(new ExampleSpecification<T>(example), probeType, limitable);
		
		query.setFirstResult(limitable.getOffset());
		query.setMaxResults(limitable.getLimit());
		List<T> list = query.getResultList();
		return list != null ? list : Collections.<T>emptyList();
	}

	@Override
	public Collection<T> limit(Example<T> example, Limitable limitable, OffsetPrimaryKeySort keySort) {

		Class<T> probeType = example.getProbeType();
		TypedQuery<T> query = getQuery(new PrimaryKeyExampleSpecification<T>(example, keySort), probeType, limitable);

		query.setFirstResult(limitable.getOffset());
		query.setMaxResults(limitable.getLimit());
		List<T> list = query.getResultList();
		return list != null ? list : Collections.<T>emptyList();
	}


	protected <S extends T> TypedQuery<S> getQuery(Specification<S> spec, Class<S> domainClass, Limitable limitable) {

		Sort sort = limitable == null ? null : limitable.getSort();
		return getQuery(spec, domainClass, sort);
	}

	protected TypedQuery<T> getQuery(Specification<T> spec, Limitable limitable) {

		Sort sort = limitable == null ? null : limitable.getSort();
		return getQuery(spec, getDomainClass(), sort);
	}

	private static class ExampleSpecification<T> implements Specification<T> {

		private final Example<T> example;

		public ExampleSpecification(Example<T> example) {
			this.example = example;
		}

		@Override
		public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

			Predicate predicate = QueryByExamplePredicateBuilder.getPredicate(root, cb, example);

			return predicate;
		}
	}

	private static class PrimaryKeyExampleSpecification<T> implements Specification<T> {

		private final Example<T> example;
		private final OffsetPrimaryKeySort keySort;

		public PrimaryKeyExampleSpecification(Example<T> example, OffsetPrimaryKeySort keySort) {
			this.example = example;
			this.keySort = keySort;
		}

		@Override
		public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
			return PrimaryKeyPredicateBuilder.getPredicate(root, cb, example, keySort);
		}
	}

}
