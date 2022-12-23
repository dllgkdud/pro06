package com.shop2.myapp.service;

import com.shop2.myapp.dto.UserDTO;

public interface UserService {
	public void addUser(UserDTO user) throws Exception;
	public UserDTO userLogin(String id, String pw) throws Exception;
}
