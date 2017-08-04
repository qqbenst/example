package com.example.demo.web.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.TestService;

@RestController
@RequestMapping(value = "/test/")
public class TestController {
	@Autowired
	TestService testService;

	@RequestMapping(value = "hello/", method = RequestMethod.GET)
	public String saveHello(){
		String ss = testService.test();
		System.out.println("hello "+ss);
		return ss;
	}
	
}
