package com.ssafy.happyhouse.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.dto.User;
import com.ssafy.happyhouse.model.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public User login(User userDto) throws Exception {
		if (userDto.getId() == null || userDto.getPwd() == null)
			return null;
		return userMapper.login(userDto);
	}

	@Override
	public boolean idCheck(String checkId) throws Exception {
		int result = userMapper.idCheck(checkId);
		return result == 0;
	}

	@Override
	public boolean registerUser(User userDto) throws Exception {
		int result = userMapper.registerUser(userDto);
		return result == 1;
	}

	@Override
	public User getUser(String userId) throws Exception {
		return userMapper.getUser(userId);
	}

	@Override
	public List<User> getUserList() throws Exception {
		return userMapper.getUserList();
	}

	@Override
	public boolean updateUser(User userDto) throws Exception {
		int result = userMapper.updateUser(userDto);
		return result == 1;
	}

	@Override
	public boolean deleteUser(String userId) throws Exception {
		int result = userMapper.deleteUser(userId);
		return result == 1;
	}

}
