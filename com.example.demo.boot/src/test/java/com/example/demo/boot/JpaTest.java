package com.example.demo.boot;

import org.apache.catalina.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.demo.dao.UserDao;
import com.example.demo.dao.model.UserModel;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=ApplicationBoot.class)
public class JpaTest {

	@Autowired
	UserDao userDao;
	
	@Test
	public void test() {
		UserModel userModel = new UserModel();
		userModel.setId(3L);
		System.out.println(userDao.selectPageByStartRow(userModel, 3L, 4L));
	}

}
