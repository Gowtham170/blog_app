package com.example.blog_app.service;

import java.util.List;

import com.example.blog_app.dto.PostDto;

public interface PostServiceImpl {
    PostDto createPost(PostDto postDto);
    List<PostDto> getAllPosts();
    PostDto getPost(long postId);
    PostDto updatePost();
    PostDto DeletePost();
}
