package com.example.demo.web.view;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test/")
public class TestController {

	@RequestMapping(value = "hello/", method = RequestMethod.GET)
	public void saveHello(){
		System.out.println("hello");
	}
	
}
