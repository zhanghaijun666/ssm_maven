package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.model.Users;

public interface UsersMapper {
	
	Users getUserById(Integer id);
	List<Users> getAllUser();
	List<Users> getAllUsersByName(String name);
	List<Users> getAllUserByState(Integer state);
	List<Users> getSearchUsers(Users users);
    int deleteUserById(Integer id);
    int deleteByState(List<Integer> list);
    int insert(Users record);
    int insertSelective(Users record);
    int updateByPrimaryKeySelective(Users record);
    int updateByPrimaryKey(Users record);
    
    List<Users> checkLogin(@Param("name") String name,@Param("password") String password);
    
    
    
    
    
    
    
}