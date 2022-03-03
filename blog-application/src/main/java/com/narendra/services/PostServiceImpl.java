package com.narendra.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.narendra.dto.PageResponse;
import com.narendra.dto.PostDto;
import com.narendra.entity.Post;
import com.narendra.exception.PostIdNotAvailableException;
import com.narendra.repository.PostRepository;

@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public PostDto createPost(PostDto postDto) {
		//convert dto into entity
		/*
		 * Post post = new Post(); post.setPostId(postDto.getPostId());
		 * post.setTitle(postDto.getTitle());
		 * post.setDescription(postDto.getDescription());
		 * post.setContent(postDto.getContent());
		 */
		
		Post post = modelMapper.map(postDto, Post.class);
		Post insertedPost = postRepository.save(post);
		
		//convert entity to dto
		/*
		 * PostDto postDto1 = new PostDto();
		 * postDto1.setPostId(insertedPost.getPostId());
		 */
		//...
		
		return modelMapper.map(insertedPost, PostDto.class);
		//return postDto1;
	}

	
	
	public PageResponse getAllPosts(int pageNumber, int pageSize, String sortBy) {
		
		Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy).descending());
		Page<Post> posts = postRepository.findAll(pageable);
		List<Post> postList = posts.getContent();
		List<PostDto> listOfPostDto = postList.stream().map(post -> modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		
		PageResponse pageResponse = new PageResponse();
		pageResponse.setContent(listOfPostDto);
		pageResponse.setPageNumber(posts.getNumber());
		pageResponse.setPageSize(posts.getSize());
		pageResponse.setTotalElements(posts.getNumberOfElements());
		pageResponse.setTotalPages(posts.getTotalPages());
		pageResponse.setLast(posts.isLast());
		return pageResponse;
	}
	
	
	
	public Post getPostByPostId(long id) {
		//return postRepository.findById(id).get();
		Optional<Post> optPost = postRepository.findById(id);
		if(optPost.isPresent()) {
			Post post = optPost.get();
			return post;
		}
		throw new PostIdNotAvailableException("" + id);
	}
	
	public void deletePostById(long postId) {
		postRepository.deleteById(postId);
	}

	public Post updatePost( int postId,  Post post) {

		Post availablePost = getPostByPostId(postId);
		availablePost.setPostId(post.getPostId());
		availablePost.setTitle(post.getTitle());
		availablePost.setDescription(post.getDescription());
		availablePost.setContent(post.getContent());
		return postRepository.save(availablePost);
	}
	
	public List<Post> getAllPostsByTitle(String title) {
		return postRepository.findByTitle(title);
	}
	
	public List<Post> findByTitleAndContent(String title, String content) {
		return postRepository.findByTitleAndContent(title, content);
	}
	
	
	
	
}


