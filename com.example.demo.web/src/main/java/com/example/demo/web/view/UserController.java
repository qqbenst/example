package com.example.demo.web.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.UserService;
import com.example.demo.service.bean.UserBean;
import com.example.demo.web.view.reqparam.UserParam;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import net.sf.cglib.beans.BeanCopier;

@RestController
@RequestMapping(value = "/users")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息")
   // @ApiImplicitParam(name = "{id}", value = "用户ID", required = true, dataType = "Long")
	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public UserBean findByid(@PathVariable Long id){
		return userService.findUserById(id);
	}
	
	@ApiOperation(value="保存用户详细信息", notes="保存用户详细信息")
	@ApiImplicitParam(name = "userParam", value = "用户ID", required = true, dataType = "UserParam")
	@ResponseBody
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public UserBean save(@RequestBody UserParam userParam){
		BeanCopier b = BeanCopier.create(UserParam.class, UserBean.class, false);
		UserBean userBean = new UserBean();
		b.copy(userParam, userBean, null);
		return userService.save(userBean);
	}
	
	@ApiOperation(value="根据id删除用户", notes="根据url的id来删除用户详细信息")
	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public boolean remove(@PathVariable Long id){
		userService.remove(id);
		return true;
	}
	@ApiOperation(value="更新用户详细信息", notes="更新用户详细信息")
	@ApiImplicitParam(name = "userParam", value = "用户信息", required = true, dataType = "UserParam")
	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public UserBean put(@PathVariable Long id,
			@RequestBody UserParam userParam){
		BeanCopier b = BeanCopier.create(UserParam.class, UserBean.class, false);
		UserBean userBean = new UserBean();
		b.copy(userParam, userBean, null);
		userBean.setId(id);
		return userService.modify(userBean);	
	}
	
}
