package com.ssafy.happyhouse.model.mapper;

import java.util.List;

import com.ssafy.happyhouse.model.dto.User;

public interface UserMapper {
	
	User login(User userDto) throws Exception;
	int idCheck(String checkId) throws Exception;
	
	int registerUser(User userDto) throws Exception;	
	User getUser(String userId) throws Exception;
	List<User> getUserList() throws Exception;
	int updateUser(User userDto) throws Exception;
	int deleteUser(String userId) throws Exception;

}
