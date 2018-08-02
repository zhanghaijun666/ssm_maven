package com.controller;

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
			mav.setViewName("jsp/home");
		} else {
			mav.addObject("error", "用户名或密码错误");
			mav.setViewName("jsp/login");
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
			mav.setViewName("jsp/home");
		}else {
			mav.addObject("errormsg", msg);
			mav.setViewName("jsp/addUser");
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
		mav.setViewName("jsp/home");
		return mav;
	}
}
