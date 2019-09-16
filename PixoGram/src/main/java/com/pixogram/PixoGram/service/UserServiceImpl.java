package com.pixogram.PixoGram.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pixogram.PixoGram.model.User;
import com.pixogram.PixoGram.repository.UserRepository;



@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	@Override
	public User loginUserCheck(String uname, String password) {
		// TODO Auto-generated method stub
		return userRepository.loginUserCheck(uname,password);
	}

	@Override
	public User signupUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.getAllUser(user);
	}
	

	@Override
	public User blockUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	
}
