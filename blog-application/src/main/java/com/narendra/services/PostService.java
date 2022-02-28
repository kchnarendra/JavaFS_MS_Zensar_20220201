package com.narendra.services;

import java.util.List;

import com.narendra.dto.PageResponse;
import com.narendra.dto.PostDto;
import com.narendra.entity.Post;

public interface PostService {
	
	public PostDto createPost( PostDto postDto);
	
	//public List<Post> getAllPosts();
	
	public Post getPostByPostId(long id);
	
	public void deletePostById(long postId);
	
	public Post updatePost( int postId,  Post post);

	public List<Post> getAllPostsByTitle(String title);
	
	public List<Post> findByTitleAndContent(String title, String content);

	public PageResponse getAllPosts(int pageNumber, int pageSize, String sortBy);
}
