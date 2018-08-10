package com.controller;

import java.util.List;
import java.util.Map;

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
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
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
	public ModelAndView doAddUser(@RequestParam("userId") Integer userId) {
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
	public String  getAllUsers(@RequestParam("page") Integer page,@RequestParam("rows") Integer rows) {
		if( page == null || page <= 0 ) {
			page = 1;
		}
		if( rows == null || rows <= 0 ) {
			rows = 10;
		}
		PageHelper.startPage(page, rows);
        List<Users> allUsers = userService.getAllUsers();
        PageInfo<Users> pageInfo=new PageInfo<>(allUsers);
        Map<String,Object> map = Maps.newHashMap();
        map.put("allUsers",allUsers);
        map.put("pageInfo",pageInfo);
        return JSON.toJSONString(map);
	}
}
