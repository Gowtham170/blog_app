package com.example.blog_app.service;

import com.example.blog_app.dto.PostDto;
import com.example.blog_app.dto.PostResponse;

public interface PostService {
    PostDto createPost(PostDto postDto);
    PostResponse getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir);
    PostDto getPostById(long postId);
    PostDto updatePost(long postId, PostDto postDto);
    void deletePost(long postId);
}
