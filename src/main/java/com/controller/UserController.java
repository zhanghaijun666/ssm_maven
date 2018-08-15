package com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.model.ResultMsg;
import com.model.Users;
import com.service.UserService;
@Controller
public class UserController {
	@Autowired
	UserService userService;

	@RequestMapping(value="/login.do",method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView doLogin(@RequestParam("username") String username,@RequestParam("password") String password,
			HttpServletRequest request, HttpServletResponse response) {
		List<Users> list = userService.checkLogin(username, password);

		ModelAndView mav = new ModelAndView();
		if( list.size() > 0) {
			request.getSession().setAttribute("user", list.get(0));
			mav.addObject("allUsers", userService.getAllUsers());
			mav.setViewName("jsp/home.jsp");
		} else {
			mav.addObject("error", "用户名或密码错误");
			mav.setViewName("jsp/login.jsp");
		}
		return mav;
	}
	
	@RequestMapping(value="/adduser.do",method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView doAddUser(@RequestParam("user") String username,@RequestParam("password") String password) {
		ModelAndView mav = new ModelAndView();
		
		Users user = new Users();
		user.setName(username);
		user.setPassword(password);
		
		String msg = userService.addUser(user);
		if("".equals(msg)) {
			mav.addObject("allUsers", userService.getAllUsers());
			mav.addObject("username", username);
			mav.setViewName("jsp/home.jsp");
		}else {
			mav.addObject("errormsg", msg);
			mav.setViewName("jsp/addUser.jsp");
		}
		return mav;
	}
	
	@RequestMapping(value="/deleteuser.do",method=RequestMethod.GET)
	@ResponseBody
	public ModelAndView deleteuser(@RequestParam("userId") Integer userId) {
		ModelAndView mav = new ModelAndView();
		int num = userService.deleteUser(userId);
		if(num > 0) {
			mav.addObject("mmsg", "删除成功！");
		}else {
			mav.addObject("mmsg", "删除失败！");
		}
		mav.addObject("allUsers", userService.getAllUsers());
		mav.setViewName("jsp/home.jsp");
		return mav;
	}
	@RequestMapping(value="/getAllUsers.do",method=RequestMethod.GET)
	@ResponseBody
	public String  getAllUsers(
			@RequestParam(value="page",defaultValue="1") Integer page,
			@RequestParam(value="rows",defaultValue="10") Integer rows,
			@RequestParam(value="name",required=false) String name,
			@RequestParam(value="email",required=false) String email) {
        return userService.getSearchUsers(page, rows, name, email);
	}
	@RequestMapping(value="/doadduser.do",method=RequestMethod.POST)
	@ResponseBody
	public String doAddUser(
			@RequestParam("name") String name,
			@RequestParam("password") String password,
			@RequestParam("fullName") String fullName,
			@RequestParam("sex") Integer sex,
			@RequestParam("birthday") Long birthday,
			@RequestParam("level") Integer level,
			@RequestParam("state") Integer state,
			@RequestParam("des") String des,
			@RequestParam("tel") String tel,
			@RequestParam("email") String email,
		    HttpServletRequest request, HttpServletResponse response) {
		Users user = new Users();
		user.setName(name);
		user.setPassword(password);
		user.setFullName(fullName);
		user.setSex(sex+"");
		user.setBirthday(birthday+""); 
		user.setLevel(level);
		user.setState(state);
		user.setDes(des);
		user.setTel(tel);
		user.setEmail(email);
		
//		@RequestBody Users user
		String msg = userService.addUser(user);
		System.out.println(msg);
		System.out.println(user.toString());
		return JSON.toJSONString(new ResultMsg(1,msg,""));
	}
	@RequestMapping(value="/deleteusers.do",method=RequestMethod.POST)
	@ResponseBody
	public String deleteusers(@RequestParam("userIds") String userIds) {
		List<Integer> list = new ArrayList<>();
		for(String id : userIds.split(",")) {
			try {
				list.add(Integer.valueOf(id));
			}catch (Exception e) {
			}
		}
		userService.deleteUser(list);
		return JSON.toJSONString(new ResultMsg(1,"",""));
	}
}
