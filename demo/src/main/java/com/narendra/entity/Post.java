package com.narendra.entity;

public class Post {

	private int postId;
	private String title;
	private String description;
	private String content;
	
	public Post() {
		super();
	}
	
	public Post(int postId, String title, String description, String content) {
		super();
		this.postId = postId;
		this.title = title;
		this.description = description;
		this.content = content;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
