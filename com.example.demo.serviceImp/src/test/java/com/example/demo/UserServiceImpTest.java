package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.demo.service.UserService;
import com.example.demo.service.bean.UserBean;
import com.example.demo.serviceImp.ApplicationBoot;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=ApplicationBoot.class)
public class UserServiceImpTest {
	@Autowired
	private UserService userService;
	@Test
	public void testFindUserById() {
		UserBean userBean =  userService.findUserById(1L);
		
		System.out.println(userBean);
	}

}
