package com.pixogram.PixoGram.service;

import java.util.List;

import com.pixogram.PixoGram.model.Follow;
import com.pixogram.PixoGram.model.User;

public interface FollowService {

	List<Follow> followUser(User user);

	Follow updateFollow(Follow follow);

	List<Follow> followers(User user);

	void unFollow(Follow follow);

	

}
