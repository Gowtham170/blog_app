package com.example.blog_app.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.blog_app.dto.CommentDto;
import com.example.blog_app.service.impl.CommentServiceImpl;

@RestController
@RequestMapping("/api/posts")
public class CommentController {

    private CommentServiceImpl commentService;

    public CommentController(CommentServiceImpl commentService) {
        this.commentService = commentService;
    }
    
    @PostMapping("{postsId}/comments")
    public ResponseEntity<CommentDto> createComment(
        @RequestBody CommentDto commentDto, 
        @PathVariable long postsId
    ) {
        return new ResponseEntity<>(commentService.createComment(commentDto,postsId), HttpStatus.CREATED);
    }

    @GetMapping("{postId}/comments")
    public ResponseEntity<List<CommentDto>> getCommentsByPostId(@PathVariable long postId) {
        return new ResponseEntity<>(commentService.getCommentsByPostId(postId), HttpStatus.OK);
    }

    @GetMapping("{postId}/comments/{id}")
    public ResponseEntity<CommentDto> getCommentById(
        @PathVariable long postId, 
        @PathVariable("id") long commentId
    ) {
        return new ResponseEntity<>(commentService.getCommentById(commentId,postId), HttpStatus.OK);
    }

    @PutMapping("{postId}/comments/{id}")
    public ResponseEntity<CommentDto> updateComment(
        @PathVariable long postId, 
        @PathVariable("id") long commentId, 
        @RequestBody CommentDto commentDto
    ) {
        return new ResponseEntity<>(commentService.updateComment(commentId, postId, commentDto), HttpStatus.OK);
    }

    @DeleteMapping("{postId}/comments/{id}")
    public ResponseEntity<String> deleteComment(
        @PathVariable long postId,
        @PathVariable long commentId
    ) {
        commentService.deleteComment(postId, commentId);
        return new ResponseEntity<>("Comment deleted successfully", HttpStatus.OK);
    }
}
