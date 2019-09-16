package com.pixogram.PixoGram.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pixogram.PixoGram.model.User;
import com.pixogram.PixoGram.service.UserService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping(value="/loginUser/{uname}/{password}")
	public User loginUserCheck(@PathVariable("uname") String uname,@PathVariable("password") String password)
	{
		
		return userService.loginUserCheck(uname,password);
		
	}
	
	//signup user
		@PostMapping(value="/signupUser")
		public User signupUser(@RequestBody User user)
		{
			
			return userService.signupUser(user);
		}
		
		//get all users
		@PostMapping(value="/users")
		public List<User> getAllUser(@RequestBody User user)
		{
			return userService.getAllUser(user);
		}
		
		@PostMapping(value="/blockuser")
		public User blockUser(@RequestBody User user)
		{
			return userService.blockUser(user);
		}

}
