package com.example.demo.dao.impl.jpa.support;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
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

        private final EntityManager em;

		public MyEasyCodeRepositoryFactoryBean(EntityManager em) {
			super(em);
			this.em = em;
		}

		 //设置具体的实现类是BaseRepositoryImpl
        @SuppressWarnings("unchecked")
		@Override
        protected Object getTargetRepository(RepositoryInformation information) {
            return new EasyCodeRepositoryImpl<T, I>((Class<T>) information.getDomainType(), em);
        }

        //设置具体的实现类的class
        @Override
        protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {
            return EasyCodeRepositoryImpl.class;
        }
	}
}
