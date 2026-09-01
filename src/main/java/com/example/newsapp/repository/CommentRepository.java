package com.example.newsapp.repository;

import com.example.newsapp.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findByNewsId(Long newsId);
}