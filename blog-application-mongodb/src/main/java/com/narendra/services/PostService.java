package com.narendra.services;

import java.util.List;

import com.narendra.entity.Post;

public interface PostService {
	
	public Post createPost( Post post);
	
	public List<Post> getAllPosts();
	
	public Post getPostByPostId(long id);
	
	public void deletePostById(long postId);
	
	public Post updatePost( int postId,  Post post);

}
