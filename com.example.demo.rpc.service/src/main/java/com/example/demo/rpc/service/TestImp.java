package com.example.demo.rpc.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.example.demo.rpc.client.Test;


@Service(version="1.0.0")
public class TestImp implements Test {

	@Override
	public String sayHello(String name) {
		System.out.println(name);
		return "Hello " + name;
	}

}
