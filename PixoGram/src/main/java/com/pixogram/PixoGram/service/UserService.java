package com.pixogram.PixoGram.service;

import java.util.List;

import com.pixogram.PixoGram.model.User;

public interface UserService {

	User loginUserCheck(String uname, String password);

	User signupUser(User user);

	List<User> getAllUser(User user);
	
	User blockUser(User user);
}
