package com.example.demo.dao.impl.jpa.support;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.convert.QueryByExamplePredicateBuilder;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.JpaEntityInformationSupport;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@Transactional(readOnly = true)
public class EasyCodeRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID>
		implements EasyCodeRepository<T, ID> {
	
	private static final String ID_MUST_NOT_BE_NULL = "The given id must not be null!";


	private final EntityManager em;
	
	public EasyCodeRepositoryImpl(Class<T> domainClass, EntityManager em) {
		this(JpaEntityInformationSupport.getEntityInformation(domainClass, em), em);
	}

	public EasyCodeRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager em) {
		super(entityInformation, em);
		this.em = em;
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

	
	/**
	 * 目前支持单表更新
	 */
	@Override
	public void saveNotNullOneTable(T e, ID id) {
		
		Assert.notNull(id, ID_MUST_NOT_BE_NULL);

		CriteriaBuilder cb=em.getCriteriaBuilder();
		CriteriaUpdate<T> op=cb.createCriteriaUpdate(this.getDomainClass());
		Root<T> root=op.from(this.getDomainClass());
	//	root.
		//这里应该要获取所有的set
		op.set("", "");
	//	op.where(cb.equal(, ""));
		em.createQuery(op).executeUpdate();
		
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
