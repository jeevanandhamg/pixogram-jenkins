package com.pixogram.PixoGram.repository;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pixogram.PixoGram.model.Follow;
import com.pixogram.PixoGram.model.User;

public interface FollowRepository extends JpaRepository<Follow,Long> {

	@Query("Select f From Follow f where f.userid=:user")
	List<Follow> followUser(@Param("user") User user);

	@Query("Select f From Follow f where f.followid=:user")
	List<Follow> followers(@Param("user")User user);

	
}
