package com.pixogram.PixoGram.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pixogram.PixoGram.model.Posts;
import com.pixogram.PixoGram.repository.PostsRepository;

@Service
public class PostsServiceImpl implements PostsService {
	
	@Autowired
	PostsRepository postsRepository;

	@Override
	public void upload(Posts post) {
		postsRepository.save(post);
		
	}

}
