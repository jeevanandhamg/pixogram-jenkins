package com.pixogram.PixoGram.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pixogram.PixoGram.model.Posts;

public interface PostsRepository extends JpaRepository<Posts,Long> {

}
