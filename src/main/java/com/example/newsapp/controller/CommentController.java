package com.example.newsapp.controller;

import com.example.newsapp.entity.Comment;
import com.example.newsapp.service.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/news/{newsId}/comments")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public String addComment(
            @PathVariable Long newsId,
            @ModelAttribute Comment comment) {

        commentService.addComment(newsId, comment);

        return "redirect:/news/" + newsId;
    }
}