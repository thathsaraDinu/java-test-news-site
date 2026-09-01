package com.example.newsapp.service;

import com.example.newsapp.entity.News;
import com.example.newsapp.repository.NewsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService {

    private final NewsRepository newsRepository;

    public NewsService(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    public News getNewsById(Long id) {
        return newsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("News not found"));
    }

    public List<News> getNewsByCategory(Long categoryId) {
        return newsRepository.findByCategoryId(categoryId);
    }
}