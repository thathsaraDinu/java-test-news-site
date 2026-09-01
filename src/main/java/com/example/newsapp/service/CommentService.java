package com.example.newsapp.service;

import com.example.newsapp.entity.Comment;
import com.example.newsapp.entity.News;
import com.example.newsapp.repository.CommentRepository;
import com.example.newsapp.repository.NewsRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final NewsRepository newsRepository;

    public CommentService(
            CommentRepository commentRepository,
            NewsRepository newsRepository) {

        this.commentRepository = commentRepository;
        this.newsRepository = newsRepository;
    }

    public List<Comment> getCommentsByNewsId(Long newsId) {
        return commentRepository.findByNewsId(newsId);
    }

    public Comment addComment(Long newsId, Comment comment) {

        News news = newsRepository.findById(newsId)
                .orElseThrow(() -> new RuntimeException("News not found"));

        comment.setNews(news);
        comment.setCreatedAt(LocalDateTime.now());

        return commentRepository.save(comment);
    }
}