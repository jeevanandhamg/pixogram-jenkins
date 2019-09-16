package com.pixogram.PixoGram.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pixogram.PixoGram.model.Follow;
import com.pixogram.PixoGram.model.User;
import com.pixogram.PixoGram.service.FollowService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/follow")
public class FollowController {

	@Autowired
	FollowService followService;
	
	@PostMapping(value="/following")
	public List<Follow> following(@RequestBody User user)
	{
		
		return followService.followUser(user);
	}
	
	@PostMapping(value="/followers")
	public List<Follow> followers(@RequestBody User user)
	{
		
		return followService.followers(user);
	}
	
	@PostMapping(value="/update")
	public Follow updateFollow(@RequestBody Follow follow)
	{
		return followService.updateFollow(follow);
	}
	
	@PostMapping(value="/unfollow")
	public void unFollow(@RequestBody Follow follow)
	{
		followService.unFollow(follow);
	}
}
