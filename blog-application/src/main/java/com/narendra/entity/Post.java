package com.narendra.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Entity
@Table(name = "post")


//2nd way == for writing queries in Post entity
//@NamedQuery(name = "Post.retrieveByTitle", query = "FROM Post p where p.title=?1")
//@NamedQuery(name = "Post.retrieveByTitleAndContent", query = "from Post p where p.title=?1 and p.title=?2")

@NamedNativeQuery(name = "Post.retrieveByTitle", query = "select * from post where title=?1", resultClass = Post.class)
@NamedNativeQuery(name = "Post.retrieveByTitleAndContent", query = "select * from post where title=?1 and content=?2", resultClass = Post.class)
@Schema(name = "MyPost")
public class Post {

	@Id
	private long postId;
	private String title;
	private String description;
	@Schema(name = "my Content")
	private String content;

}