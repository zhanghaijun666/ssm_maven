package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.UsersMapper;
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
		return userDao.getAllUserByState(1);
	}
	
	public String addUser(Users user) {
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
		return userDao.deleteByState(userId);
	}
}
