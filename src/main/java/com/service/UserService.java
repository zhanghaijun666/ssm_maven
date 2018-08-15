package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.dao.UsersMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.model.Users;

@Service
public class UserService {
	@Autowired
	UsersMapper userDao;
	
	public List<Users> checkLogin(String userName, String passWord) {
		List<Users> list = userDao.checkLogin(userName, passWord);
		//List<Users> list = userDao.checkLogin(userName, MD5Util.getMD5(passWord));
		return list;
	}
	public List<Users> getAllUsers(){
		 return userDao.getAllUser();
	}
	public String getSearchUsers(Integer page,Integer rows,String name,String email){
		if( page == null || page <= 0 ) {
			page = 1;
		}
		if( rows == null || rows <= 0 ) {
			rows = 10;
		}
		PageHelper.startPage(page, rows);//必须写到查询之前
		Users user = new Users();
		user.setName(name);
		user.setEmail(email);
		List<Users> allUsers = userDao.getSearchUsers(user);
        PageInfo<Users> pageInfo=new PageInfo<>(allUsers);
        Map<String,Object> map = Maps.newHashMap();
        System.out.println(pageInfo.toString());
        map.put("total",pageInfo.getTotal());
        map.put("rows",allUsers);
        return JSON.toJSONString(map);
	}
	
	public String addUser(Users user) {
		if( StringUtils.isEmpty(user.getName()) 
				|| StringUtils.isEmpty(user.getPassword()) ) {
			return "用户名或密码不能为空!";
		}
		
		List<Users> list = userDao.getAllUsersByName(user.getName());
 		if(list.isEmpty()) {
 			user.setState(1);
 			//user.setPassword(MD5Util.getMD5(user.getPassword()));
 			userDao.insert(user);
 			return "";
 		}else {
 			return"用户名已存在";
 		}
	}
	
	public int deleteUser(Integer userId) {
		return userDao.deleteByState(new ArrayList<>(userId));
	}
	public int deleteUser(List<Integer> list){
		return userDao.deleteByState(list);
	}
}
