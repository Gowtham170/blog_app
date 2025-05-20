package com.example.blog_app.service;

import java.util.List;

import com.example.blog_app.dto.CommentDto;

public interface CommentService {
    CommentDto createComment(CommentDto commentDto, long postsId);
    List<CommentDto> getCommentsByPostId(long postId);
    CommentDto getCommentById(long commentId,long postId);
    CommentDto updateComment(long commentId, long postId, CommentDto commentDto);
    void deleteComment(long postId, long commentId);
}
