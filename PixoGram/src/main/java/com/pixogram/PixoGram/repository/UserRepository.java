package com.pixogram.PixoGram.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pixogram.PixoGram.model.User;

public interface UserRepository extends JpaRepository<User,Long> {

	@Query("Select u From User u where u.email = :uname and u.password = :password ")
	User loginUserCheck(@Param("uname") String uname,@Param("password") String password);

	@Query("Select u From User u where u != :user ")
	List<User> getAllUser(@Param("user") User user);
	
}
