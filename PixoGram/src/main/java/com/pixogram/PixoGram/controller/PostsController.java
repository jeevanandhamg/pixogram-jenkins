package com.pixogram.PixoGram.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.pixogram.PixoGram.model.Posts;
import com.pixogram.PixoGram.model.User;
import com.pixogram.PixoGram.service.PostsService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/posts")
public class PostsController {

	@Autowired
	PostsService postService;
	
	 @PostMapping("/upload")
	    public String uploadMultipartFile(@RequestParam("user") User user,@RequestParam("file") MultipartFile file,@RequestParam("title") String title,@RequestParam("description") String description) {
	    	try {
	    		// save file to PostgreSQL
		    	Posts post = new Posts();
		    	post.setImage( file.getBytes());
		    	post.setTitle(title);
		    	post.setDescription(description);
		    	postService.upload(post);
		    	return "File uploaded successfully! -> filename = " + file.getOriginalFilename();
			} catch (	Exception e) {
				return "FAIL! Maybe You had uploaded the file before or the file's size > 500KB";
			}    
	    }
}
