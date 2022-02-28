package com.narendra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.narendra.entity.Post;


public interface PostRepository extends JpaRepository<Post,Long>{

	// 1st way == directly works without any implemenation by developer
	List<Post> findByTitle(String title);
	List<Post> findByTitleAndContent(String title, String content);
	
	// 2nd way == for writing queries in Post entity, also has code in Post.java
	List<Post> retrieveByTitle(String title);
	List<Post> retrieveByTitleAndContent(String title, String content);
	
	
	// 3rd way == for writing queries in Post entity
	//@Query("FROM Post p where p.title=?1")
	//@Query("FROM Post p where p.title:title")
	//List<Post> retrieveByTitle1(String title);
	//@Query(value = "select * from post where title=?1 and content=?2", nativeQuery = true)
	//@Query(value = "select * from post where title:myTitle and content=myContent", nativeQuery = true)
	//List<Post> retrieveByTitleAndContent1(@Param("myTitle") String title, @Param("myContent") String content);
	
	
}