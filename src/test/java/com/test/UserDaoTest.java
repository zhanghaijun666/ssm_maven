package com.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dao.UsersMapper;
import com.model.Users;

/**
 * 配置spring和junit整合，junit启动时加载springIOC容器 spring-test,junit
 */
@RunWith(SpringJUnit4ClassRunner.class)
// 告诉junit spring配置文件
@ContextConfiguration({ "classpath:spring/applicationContext.xml"})
public class UserDaoTest {
	
	@Autowired
	UsersMapper userDao;
	
	@Test
	public void getStudent() {
		List<Users> users = userDao.checkLogin("a","a");
		if(!users.isEmpty()) {
			System.out.println("--------------------"+users.get(0).getName());
		}
		
	}
	
}
