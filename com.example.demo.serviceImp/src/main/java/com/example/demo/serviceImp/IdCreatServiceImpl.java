package com.example.demo.serviceImp;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.service.IdCreatService;
import com.example.demo.service.NextIdService;

@Service
public class IdCreatServiceImpl implements IdCreatService {

	private static final Map<String, AtomicLong> identityMap = new HashMap<String, AtomicLong>();
	
	@Autowired
	private NextIdService nextIdService;
	
	@Override
	public long nextId(String system, String subSys, String module, String tableName) {
		
		String cachedKey = system + subSys + module + tableName;
		AtomicLong identityAtomicLong = identityMap.get( cachedKey );
		if( identityAtomicLong == null ) {
			Long idprefix = nextIdService.findIdPrefix( system, subSys, module, tableName );
			identityAtomicLong = new AtomicLong( idprefix * 100 + 1);
			identityMap.put( cachedKey, identityAtomicLong );
		}
		Long idvalue = identityAtomicLong.getAndIncrement();
		if( idvalue % 100 == 0 ) {
			Long idprefix = nextIdService.findIdPrefix( system, subSys, module, tableName );
			identityAtomicLong = new AtomicLong( idprefix * 100 + 1);
			identityMap.put( cachedKey, identityAtomicLong );
		}
		return idvalue;
	}

}
