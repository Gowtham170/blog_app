package com.example.blog_app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.blog_app.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long>{
    List<Comment> findByPostId(long id);
}
