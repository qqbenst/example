package com.example.demo.serviceImp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.example.demo.dao.NextIdDao;
import com.example.demo.dao.model.NextId;
import com.example.demo.service.NextIdService;

@Service
public class NextIdServiceImpl implements NextIdService {

	@Autowired
	private NextIdDao nextIdDao;
	
	@Override
	public long findIdPrefix(String system, String subSys, String module, String tableName) {
		List<NextId> nextIdlist = new ArrayList<NextId>(); 
		nextIdlist = nextIdDao.findAll(new Specification<NextId>() {
			
			@Override
			public Predicate toPredicate(Root<NextId> arg0, CriteriaQuery<?> arg1, CriteriaBuilder arg2) {
				List<Predicate> list = new ArrayList<Predicate>();
				if(system != null){
					list.add(arg2.equal(arg0.get("system").as(String.class), system));
				}
				if(subSys != null){
					list.add(arg2.equal(arg0.get("subSys").as(String.class), subSys));
				}
				if(module != null){
					list.add(arg2.equal(arg0.get("module").as(String.class), module));
				}
				if(tableName != null){
					list.add(arg2.equal(arg0.get("tableName").as(String.class), tableName));
				}
				Predicate[] p = new Predicate[list.size()];
	            return arg2.and(list.toArray(p));
			}
		});
		
		NextId newNextId = new NextId();
		
		newNextId.setSystem(system);
		newNextId.setSubSys(subSys);
		newNextId.setModule(module);
		newNextId.setTableName(tableName);
		
		if(nextIdlist.size()>0){
			newNextId.setId(nextIdlist.get(0).getId());
			newNextId.setIdPrefix(nextIdlist.get(0).getIdPrefix()+1);
			nextIdDao.save(newNextId);
			return newNextId.getIdPrefix();
		}else{
			newNextId.setIdPrefix(0);
			nextIdDao.save(newNextId);
			return 0;
		}
	}

}
