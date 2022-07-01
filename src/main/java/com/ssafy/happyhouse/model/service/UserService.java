package com.ssafy.happyhouse.model.service;

import java.util.List;

import com.ssafy.happyhouse.model.dto.User;


public interface UserService {
	User login(User userDto) throws Exception;
	boolean idCheck(String checkId) throws Exception;
	
	boolean registerUser(User userDto) throws Exception;
	User getUser(String userId) throws Exception;
	List<User> getUserList() throws Exception;
	boolean updateUser(User userDto) throws Exception;
	boolean deleteUser(String userId) throws Exception;
}
