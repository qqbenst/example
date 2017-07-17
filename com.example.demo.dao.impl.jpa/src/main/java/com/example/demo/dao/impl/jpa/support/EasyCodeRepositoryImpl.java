package com.example.demo.dao.impl.jpa.support;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Path;
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

import net.sf.cglib.beans.BeanMap;

@Transactional(readOnly = true)
public class EasyCodeRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID>
		implements EasyCodeRepository<T, ID> {
	
	private static final String MUST_NOT_BE_NULL = "The given  must not be null!";
	private final JpaEntityInformation<T, ?> entityInformation;

	private final EntityManager em;
	
	public EasyCodeRepositoryImpl(Class<T> domainClass, EntityManager em) {
		this(JpaEntityInformationSupport.getEntityInformation(domainClass, em), em);
	}

	public EasyCodeRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager em) {
		super(entityInformation, em);
		this.em = em;
		this.entityInformation = entityInformation;
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
	@Transactional
	@Override
	public int updateNotNullOneTable(T e, Example<T> example) {

		Assert.notNull(example, MUST_NOT_BE_NULL);
		BeanMap beanMap = BeanMap.create(e);
		em.clear();

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaUpdate<T> op = cb.createCriteriaUpdate(getDomainClass());
		Root<T> root = op.from(this.getDomainClass());

		// root.
		// 这里应该要获取所有的set

		@SuppressWarnings("unchecked")
		Iterator<Map.Entry<String, Object>> it = beanMap.entrySet().iterator();

		while (it.hasNext()) {
			Map.Entry<String, Object> temp = it.next();
			if (temp.getValue() != null) {
				op.set(temp.getKey(), temp.getValue());
			}
		}
		
		Predicate predicate = QueryByExamplePredicateBuilder.getPredicate(root, cb, example);
		op.where(predicate);
		return em.createQuery(op).executeUpdate();

	}

	@Override
	public int updateNotNullOneTable(T t, Iterator<ID> ids) {
		Assert.notNull(ids, MUST_NOT_BE_NULL);
		BeanMap beanMap = BeanMap.create(t);
		em.clear();

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaUpdate<T> op = cb.createCriteriaUpdate(getDomainClass());
		Root<T> root = op.from(getDomainClass());

		
		
		// root.
		// 这里应该要获取所有的set

		@SuppressWarnings("unchecked")
		Iterator<Map.Entry<String, Object>> it = beanMap.entrySet().iterator();

		while (it.hasNext()) {
			Map.Entry<String, Object> temp = it.next();
			if (temp.getValue() != null) {
				op.set(temp.getKey(), temp.getValue());
			}
		}
		Predicate predicate = null;
		
		if (!entityInformation.hasCompositeId()) {
			Path<?> path = root.get(entityInformation.getIdAttribute());
			predicate = cb.in(path).in(ids);
		}
		
		
		
		Class<?> ID = entityInformation.getIdType();
		predicate = predicate.in(ids);
		System.out.println(ID.getName());
//		Path<?> path = root.get(entityInformation.getIdAttribute());
		
	/*	@SuppressWarnings("rawtypes")
		ParameterExpression<Iterable> parameter = cb.parameter(Iterable.class);
		Predicate predicate = path.in(parameter);
		
		
		ByIdsSpecification<T> specification =new ByIdsSpecification<T>(entityInformation);
		
		predicate = specification.toPredicate(root, null, cb);*/
/*		Predicate predicate = new InPredicate<>(cb,ids)*/
		
		op.where(predicate.in(ids));
		
		return em.createQuery(op).executeUpdate();
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

 	@SuppressWarnings("rawtypes")
	private static final class ByIdsSpecification<T> implements Specification<T> {

		private final JpaEntityInformation<T, ?> entityInformation;

		ParameterExpression<Iterable> parameter;

		public ByIdsSpecification(JpaEntityInformation<T, ?> entityInformation) {
			this.entityInformation = entityInformation;
		}

		public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

			Path<?> path = root.get(entityInformation.getIdAttribute());
			parameter = cb.parameter(Iterable.class);
			return path.in(parameter);
		}
	}
	 

}
