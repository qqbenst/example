package com.example.demo.dao.impl.jpa.support;

import static org.springframework.data.querydsl.QueryDslUtils.QUERY_DSL_PRESENT;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.jpa.repository.support.QueryDslJpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.core.RepositoryInformation;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

@NoRepositoryBean
public class EasyCodeRepositoryFactoryBean<R extends JpaRepository<T, I>, T, I extends Serializable>
		extends JpaRepositoryFactoryBean<R, T, I> {

	public EasyCodeRepositoryFactoryBean(Class<? extends R> repositoryInterface) {
		super(repositoryInterface);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected RepositoryFactorySupport createRepositoryFactory(EntityManager em) {
		return new MyEasyCodeRepositoryFactoryBean<T, I>(em);
	}

	private static class MyEasyCodeRepositoryFactoryBean<T, I extends Serializable> extends JpaRepositoryFactory {


		public MyEasyCodeRepositoryFactoryBean(EntityManager em) {
			super(em);
		}

		// 设置具体的实现类
		@Override
		protected Object getTargetRepository(RepositoryInformation information) {
			return super.getTargetRepository(information);
		}

		// 设置具体的实现类的class
		@Override
		protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {
			// TODO 待增加对QueryDsl的支持
			if (isQueryDslExecutor(metadata.getRepositoryInterface())) {
				return QueryDslJpaRepository.class;
			} else {
				return EasyCodeRepositoryImpl.class;
			}
		}

		private boolean isQueryDslExecutor(Class<?> repositoryInterface) {

			return QUERY_DSL_PRESENT && QueryDslPredicateExecutor.class.isAssignableFrom(repositoryInterface);
		}
	}
}
