package com.narendra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.data.domain.Sort;

import com.narendra.dto.PageResponse;
import com.narendra.dto.PostDto;
import com.narendra.entity.Post;
import com.narendra.exception.PostIdNotAvailableException;
import com.narendra.services.PostService;

@RestController
@RequestMapping("/api/posts")
public class PostController {

	@Autowired
	private PostService postService;

	// @RequestMapping(value = "/api/posts",method = RequestMethod.POST)
	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto) {
		PostDto post2 = postService.createPost(postDto);
		return new ResponseEntity<PostDto>(post2, HttpStatus.CREATED);
	}

	// @RequestMapping(value = "/api/posts",method = RequestMethod.GET)
	@GetMapping()
	public PageResponse getAllPosts(
			@RequestParam(value = "pageNumber", defaultValue = "0", required = false) int pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "5", required = false) int pageSize,
			@RequestParam(value = "sortBy", defaultValue = "postId", required = false) String sortBy) {
	
		return postService.getAllPosts(pageNumber, pageSize, sortBy);
	}

	// @RequestMapping(value = "/api/posts/{postId}",method = RequestMethod.GET)
	@GetMapping(value = "/{postId}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public Post getPostByPostId(@PathVariable("postId") int id) {
		return postService.getPostByPostId(id);
	}

	@DeleteMapping("/{postId}")
	public void deletePostById(@PathVariable("postId") int postId) {
		postService.deletePostById(postId);
	}

	@PutMapping("/{postId}")
	public Post updatePost(@PathVariable("postId") int postId, @RequestBody Post post) {
		return postService.updatePost(postId, post);
	}
	
	@GetMapping(value = "/title/{postTitle}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public List<Post> getPostByPostTitle(@PathVariable("postTitle") String postTitle) {
		return postService.getAllPostsByTitle(postTitle);
	}
	
	@GetMapping(value = "/title/{postTitle}/{content}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public List<Post> getPostByPostTitleAndContent(@PathVariable("postTitle") String postTitle, @PathVariable("postTitle") String content) {
		return postService.findByTitleAndContent(postTitle, content);
	}
	
	@ExceptionHandler(value = {PostIdNotAvailableException.class})
	public ResponseEntity<String> handlePostIdError(RuntimeException exception, WebRequest request) {
		System.out.println("I am inside PostController");
		return new ResponseEntity<String>("Post id not available", HttpStatus.BAD_REQUEST);
	}
	
}