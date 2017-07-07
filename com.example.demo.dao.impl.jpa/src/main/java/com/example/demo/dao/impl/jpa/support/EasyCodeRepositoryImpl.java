package com.example.demo.dao.impl.jpa.support;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
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
import org.springframework.util.Assert;

@Transactional(readOnly = true)
public class EasyCodeRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, Serializable>
		implements EasyCodeRepository<T, Serializable> {

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

		return query.getFirstResult() > 0 ? query.getResultList() : Collections.<T>emptyList();
	}

	protected <S extends T> TypedQuery<S> getQuery(Specification<S> spec, Class<S> domainClass, Limitable limitable) {

		Sort sort = limitable == null ? null : limitable.getSort();
		return getQuery(spec, domainClass, sort);
	}

	
	private static class ExampleSpecification<T> implements Specification<T> {

		private final Example<T> example;

		/**
		 * Creates new {@link ExampleSpecification}.
		 *
		 * @param example
		 */
		public ExampleSpecification(Example<T> example) {

			Assert.notNull(example, "Example must not be null!");
			this.example = example;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.springframework.data.jpa.domain.Specification#toPredicate(javax.
		 * persistence.criteria.Root, javax.persistence.criteria.CriteriaQuery,
		 * javax.persistence.criteria.CriteriaBuilder)
		 */
		@Override
		public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
			return QueryByExamplePredicateBuilder.getPredicate(root, cb, example);
		}
	}
}
