package com.shop2.myapp.service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop2.myapp.dto.UserDTO;
import com.shop2.myapp.model.UserMapper;
import com.shop2.myapp.util.AES256;

@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper userMapper;
	
	@Autowired
	private HttpSession session;

	@Override
	public void addUser(UserDTO user) throws Exception {
		userMapper.addUser(user);
	}

	@Override
	public UserDTO userLogin(String id, String pw) throws Exception {
		return userMapper.userLogin(id, pw);
	}
}
