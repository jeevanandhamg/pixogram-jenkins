package com.pixogram.PixoGram.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pixogram.PixoGram.model.Follow;
import com.pixogram.PixoGram.model.User;
import com.pixogram.PixoGram.repository.FollowRepository;

@Service
public class FollowServiceImpl implements FollowService {

	@Autowired
	FollowRepository followRepository;
	
	@Override
	public List<Follow> followUser(User user) {
		// TODO Auto-generated method stub
		return followRepository.followUser(user);
	}

	@Override
	public Follow updateFollow(Follow follow) {
		// TODO Auto-generated method stub
		return followRepository.save(follow);
	}

	@Override
	public List<Follow> followers(User user) {
		// TODO Auto-generated method stub
		return followRepository.followers(user);
	}

	@Override
	public void unFollow(Follow follow) {
		// TODO Auto-generated method stub
		followRepository.delete(follow);
	}

}
