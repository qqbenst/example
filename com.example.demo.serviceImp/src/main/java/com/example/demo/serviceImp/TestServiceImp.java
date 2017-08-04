package com.example.demo.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.easy.code.sequence.rpc.client.IdSequence;
import com.example.demo.service.TestService;

@Service
public class TestServiceImp implements TestService {

	@Autowired
	IdSequence idSequence;
	
	
	@Override
	public String test() {
		// TODO Auto-generated method stub
		return idSequence.next("test1")+"";
	}

}
