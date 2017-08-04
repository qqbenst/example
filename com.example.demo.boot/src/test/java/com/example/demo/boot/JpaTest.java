package com.example.demo.boot;

import org.apache.catalina.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.demo.dao.UserDao;
import com.example.demo.dao.model.UserModel;

@SuppressWarnings("unused")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=ApplicationBoot.class)
public class JpaTest {

	@Autowired
	UserDao userDao;
	@Autowired
//	IdSequence idSequence;
	
	@Test
	public void test() {
		UserModel userModel = new UserModel();
		userModel.setName("12345");
		//userModel.setId(1L);
	//	System.out.println(userDao.selectPageByStartPrimaryKey(userModel, 10));
		//System.out.println(userDao.selectPageByStartRow(userModel, 3L, 4L));
		//System.out.println("mdmdmd"+idSequence.next("test1"));
		Object [] longs = new Long[]{
			1L,2L,3L,4L,5L
		};
		System.out.println(userDao.updateByPrimaryKeysNotNull(userModel, longs));
	//	System.out.println(userDao.selectByPrimaryKeys(longs));
	}

}
