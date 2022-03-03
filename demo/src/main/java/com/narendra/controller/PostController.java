package com.narendra.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.narendra.entity.Post;

@RestController
public class PostController {

	private List<Post> posts = new ArrayList<Post>();
	
	//@RequestMapping(value = "/api/posts", method = RequestMethod.POST)
	@GetMapping(value = "/api/posts", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_ATOM_XML_VALUE})
	public boolean createPost(@RequestBody Post post) {
		return posts.add(post);
	}
	
	//@RequestMapping(value = "/api/posts", method = RequestMethod.GET)
	//@PostMapping("/api/posts")
	@PostMapping(value = "/api/posts", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_ATOM_XML_VALUE})
	public List<Post> getAllPosts() {
		return posts;
	}
	
	@DeleteMapping("/api/posts/{postId}")
	public void deletePostByPostId(@PathVariable("postId") int id) {
		for(Post post : posts) {
			if(post.getPostId() == id) {
				posts.remove(id);
			}
		}
	}
	
	//@RequestMapping( value = "/api/posts/{postId}", method = RequestMethod.GET)
	@PutMapping("/api/posts/{postId}")
	public Post getPostByPostId(@PathVariable("postId") int id, @RequestBody Post post) {
		for(Post pst : posts) {
			if(pst.getPostId() == id) {
				pst.setTitle(post.getTitle());
				pst.setContent(post.getContent());
				pst.setDescription(post.getDescription());
			}
			return pst;
		}
		return null;
	}
}
