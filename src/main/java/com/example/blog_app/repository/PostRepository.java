package com.example.blog_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.blog_app.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long>{
    
}
