package com.example.demo.web.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.UserService;
import com.example.demo.service.bean.UserBean;

@RestController
@RequestMapping(value = "/user/")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public UserBean findByid(@PathVariable long id){
		System.out.println(id);
		return userService.findUserById(id);
	}
	
}
